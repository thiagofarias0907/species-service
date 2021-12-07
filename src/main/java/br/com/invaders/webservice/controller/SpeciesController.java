package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.Specie;
import br.com.invaders.webservice.http.KinghostAPI;
import br.com.invaders.webservice.repositories.SpeciesRepository;
import br.com.invaders.webservice.utils.KingdomEnum;
import br.com.invaders.webservice.utils.SpeciesKeys;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.invaders.webservice.parameters.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/species")
public class SpeciesController implements  Controller{

    @Autowired
    SpeciesRepository speciesRepository;

    @Override
    @GetMapping("")
    public List getAll() {
        return speciesRepository.findAll();
    }


    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return speciesRepository.findById(id);
    }

    @GetMapping("/kingdom/{id}")
    public List getByKingdomId(@PathVariable Long id){
        return speciesRepository.findByKingdomId(id);
    }


    @GetMapping("/kingdom/name/{kingdom}")
    public List getByKingdomName(@PathVariable String kingdom){
        return speciesRepository.findByKingdom(kingdom);
    }

    @Override
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public List insertAll(@RequestBody List speciesList) {
        return speciesRepository.saveAll(speciesList);
    }

    @Override
    @GetMapping("/stats")
    public JSONObject getEstatisticas() {
        return null;
    }

    @GetMapping("/source/all")
    public List getAllFromSource() {
        KinghostAPI kinghostAPI = new KinghostAPI();
        AllSpeciesParameter allSpeciesParameter = new AllSpeciesParameter(-1,999);
        JSONArray allSpecies = kinghostAPI.get(KinghostAPI.ALL_SPECIES_URL, allSpeciesParameter);


        this.insertAll(processData(allSpecies).toList());

        return allSpecies.toList();
    }

    private JSONArray processData(JSONArray specieList){
        Map<String,String> speciesKeysMap = new SpeciesKeys().getHashMap();
        JSONArray newJsonArray = new JSONArray();
        specieList.forEach( object -> {
            JSONObject jsonObject = (JSONObject) object;
            JSONObject newJsonObject = new JSONObject();
            jsonObject.keySet().forEach(key -> {
                newJsonObject.put(speciesKeysMap.get(key),jsonObject.get(key));
            });

            //set Kingdom propper ID
            newJsonObject.put("kingdomId",KingdomEnum.valueOf(newJsonObject.get("kingdom").toString()).getId());

            Gson gson = new Gson();
//            JsonElement jsonElement = gson.toJsonTree(newJsonObject);
            Specie specie = gson.fromJson(newJsonObject.toString(), Specie.class);
            newJsonArray.put(specie);
        });


        return newJsonArray;
    }
}
