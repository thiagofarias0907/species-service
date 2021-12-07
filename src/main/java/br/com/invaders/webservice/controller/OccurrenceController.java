package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.Occurrence;
import br.com.invaders.webservice.http.KinghostAPI;
import br.com.invaders.webservice.parameters.SpecieOccurenceParameter;
import br.com.invaders.webservice.repositories.OccurrenceRepository;
import br.com.invaders.webservice.utils.OccurrenceKeys;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController implements Controller {

    @Autowired
    OccurrenceRepository occurrenceRepository;

    @Override
    @GetMapping("")
    public List getAll() {
        return this.occurrenceRepository.findAll();
    }

    @Override
    @PostMapping("")
    public List insertAll(@RequestBody List list) {
        return this.occurrenceRepository.saveAll(list);
    }

    @GetMapping("/{scientific_name}")
    public List getBySpecieId(@PathVariable String scientific_name) {
        return this.occurrenceRepository.findAllByScientificName(scientific_name);
    }

    @Override
    @GetMapping("/stats")
    public JSONObject getEstatisticas() {
        return null;
    }


    @GetMapping("/source")
    public List getAllFromSource(@RequestParam int[] speciesArray, @RequestParam int specieType) {
        KinghostAPI kinghostAPI = new KinghostAPI();
        SpecieOccurenceParameter parameter = new SpecieOccurenceParameter(speciesArray,specieType);
        JSONArray allOccurrences = kinghostAPI.get(KinghostAPI.ALL_OCCURRENCES_URL, parameter);


        this.insertAll(processData(allOccurrences).toList());

        return allOccurrences.toList();
    }


    private JSONArray processData(JSONArray occurrenceList){
        Map<String,String> keysHashMap = new OccurrenceKeys().getHashMap();
        JSONArray newJsonArray = new JSONArray();
        occurrenceList.forEach( object -> {
            JSONObject jsonObject = (JSONObject) object;
            JSONObject newJsonObject = new JSONObject();
            jsonObject.keySet().forEach(key -> {
                if(keysHashMap.containsKey(key))
                    newJsonObject.put(keysHashMap.get(key),jsonObject.get(key));
            });
            Gson gson = new Gson();
//            JsonElement jsonElement = gson.toJsonTree(newJsonObject);
            Occurrence occurrence = gson.fromJson(newJsonObject.toString(), Occurrence.class);
            newJsonArray.put(occurrence);
        });


        return newJsonArray;
    }
}
