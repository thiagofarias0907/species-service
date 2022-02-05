package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.*;
import br.com.invaders.webservice.http.KinghostAPI;
import br.com.invaders.webservice.parameters.SpecieOccurenceParameter;
import br.com.invaders.webservice.repositories.KingdomRepository;
import br.com.invaders.webservice.repositories.OccurrenceRepository;
import br.com.invaders.webservice.repositories.SpeciesRepository;
import br.com.invaders.webservice.repositories.StateRepository;
import br.com.invaders.webservice.utils.OccurrenceKeys;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController implements Controller {

    @Autowired
    OccurrenceRepository occurrenceRepository;

    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    KingdomRepository kingdomRepository;

    @Autowired
    StateRepository stateRepository;

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

    @Override
    @GetMapping("stats")
    public long getEstatisticas() {
        return occurrenceRepository.count();
    }

    @GetMapping("/{scientific_name}")
    public List getBySpecieId(@PathVariable String scientific_name) {
        return this.occurrenceRepository.findAllBySpecie_scientificName(scientific_name);
    }

    @GetMapping("/filter")
    public List getAllWithFilters(@RequestParam @Nullable Long kingdomId, @RequestParam @Nullable Long specieId, @RequestParam @Nullable Long stateId) {
        Kingdom kingdom = null;
        State   state   = null;
        Specie  specie  = null;

        if (kingdomId != null)
            kingdom = kingdomRepository.findById(kingdomId).orElse(null);
        if (stateId != null)
            state   = stateRepository.findById(stateId).orElse(null);
        if (specieId != null)
            specie  = speciesRepository.findById(specieId).orElse(null);
        if (kingdomId != null) {
            if (kingdomId == 0l) {
                if (state != null)
                    return occurrenceRepository.findAllByState(state.getState());
                return occurrenceRepository.findAll();
            }
        }


        if (specie !=  null) {
            if (state != null)
                return this.occurrenceRepository.findAllBySpecie_scientificNameAndState(specie.getScientificName(), state.getState());
            return this.occurrenceRepository.findAllBySpecie_scientificName(specie.getScientificName());
        } else if (kingdom != null){
            List<Specie> specieList = speciesRepository.findByKingdomId(kingdomId);
            List specieNamesList = new ArrayList();
            for (Object specie1 : specieList){
                specieNamesList.add(((Specie)specie1).getScientificName());
            }

            if (state != null)
                return  this.occurrenceRepository.findFromSpeciesAndState(specieNamesList,state.getState());
            return  this.occurrenceRepository.findFromSpecies(specieNamesList);

        } else if (state != null) {
            return this.occurrenceRepository.findAllByState(state.getState());
        }
        return new ArrayList();
    }

    @GetMapping("/nearby")
    public List getAllNearbyOccurrences(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double precision){
        return occurrenceRepository.findAllNearby(latitude,longitude,precision);
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
            Occurrence occurrence = gson.fromJson(newJsonObject.toString(), Occurrence.class);
            newJsonArray.put(occurrence);
        });


        return newJsonArray;
    }

    @GetMapping("stats/specie/{specieId}")
    protected long getCountSpeciesOccurrences(@PathVariable long specieId) {
        long response = occurrenceRepository.countBySpecie_Id(specieId);
        return response;
    }

    @GetMapping("stats/kingdom/name/{kingdom}")
    protected long getCountKingdomOccurrences(@PathVariable String kingdom) {
        long response = occurrenceRepository.countBySpecie_Kingdom(kingdom);
        return response;
    }

    @GetMapping("stats/kingdom/{kingdomId}")
    protected long getCountKingdomIdOccurrences(@PathVariable long kingdomId) {
        long response = occurrenceRepository.countBySpecie_KingdomId(kingdomId);
        return response;
    }

    @GetMapping("stats/family/{family}")
    protected long getCountFamilyOccurrences(@PathVariable String family) {
        long response = occurrenceRepository.countBySpecie_Family(family);
        return response;
    }

    @GetMapping("stats/specie/{specieId}/state/{state}")
    protected long getCountSpeciesByStateOccurrences(@PathVariable long specieId,@PathVariable  String state) {
        long response = occurrenceRepository.countBySpecie_IdAndState(specieId,state);
        return response;
    }

}