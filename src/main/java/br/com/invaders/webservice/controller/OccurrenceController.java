package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.Kingdom;
import br.com.invaders.webservice.entities.Occurrence;
import br.com.invaders.webservice.entities.Specie;
import br.com.invaders.webservice.entities.State;
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

    @GetMapping("/{scientific_name}")
    public List getBySpecieId(@PathVariable String scientific_name) {
        return this.occurrenceRepository.findAllByScientificName(scientific_name);
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

        if (kingdomId == 0l){
            if(state!=null)
                return occurrenceRepository.findAllByState(state.getState());
            return occurrenceRepository.findAll();
        }


        if (specie !=  null) {
            if (state != null)
                return this.occurrenceRepository.findAllByScientificNameAndState(specie.getScientificName(), state.getState());
            return this.occurrenceRepository.findAllByScientificName(specie.getScientificName());
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
//
//
//    @GetMapping("/filter")
//    public List getAllWithKingdomAndStateFilters(@RequestParam Long kingdomId, @RequestParam Long stateId) {
//        Kingdom kingdom = kingdomRepository.getById(kingdomId);
//        State state = stateRepository.getById(stateId);
//
//
//        if (kingdom != null){
//            List<Specie> specieList = speciesRepository.findAllByKingdomId(kingdomId);
//            List specieNamesList = new ArrayList();
//            for (Object specie1 : specieList){
//                specieNamesList.add(((Specie)specie1).getScientificName());
//            }
//
//            if (state != null)
//                return  this.occurrenceRepository.findFromSpeciesAndState(specieNamesList,state.getState());
//            return  this.occurrenceRepository.findFromSpecies(specieNamesList);
//
//        }
//        return this.occurrenceRepository.findAllByState(state.getState());
//    }
//
//    @GetMapping("/filter")
//    public List getAllWithKingdomFilter(@RequestParam Long kingdomId) {
//        Kingdom kingdom = kingdomRepository.getById(kingdomId);
//
//        if (kingdom != null){
//            List<Specie> specieList = speciesRepository.findAllByKingdomId(kingdomId);
//            List specieNamesList = new ArrayList();
//            for (Object specie1 : specieList){
//                specieNamesList.add(((Specie)specie1).getScientificName());
//            }
//            return  this.occurrenceRepository.findFromSpecies(specieNamesList);
//
//        }
//        return new ArrayList();
//    }
//
//    @GetMapping("/filter")
//    public List getAllWithStateFilter(@RequestParam Long stateId) {
//        State state = stateRepository.getById(stateId);
//        if (state.getState() != null)
//            return this.occurrenceRepository.findAllByState(state.getState());
//        return new ArrayList();
//    }

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
