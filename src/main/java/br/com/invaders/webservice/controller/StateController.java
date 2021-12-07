package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.State;
import br.com.invaders.webservice.http.KinghostAPI;
import br.com.invaders.webservice.repositories.StateRepository;
import br.com.invaders.webservice.utils.StateKeys;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/states")
public class StateController implements Controller {

    @Autowired
    StateRepository stateRepository;

    @GetMapping("")
    @Override
    public List getAll() {
        return this.stateRepository.findAll();
    }

    @GetMapping("{id}")
    public Object getById(@PathVariable Long id) {
        return this.stateRepository.findById(id);
    }

    @PostMapping("")
    @Override
    public List insertAll(List list) {
        return this.stateRepository.saveAll(list);
    }

    @GetMapping("/stats")
    @Override
    public JSONObject getEstatisticas() {
        return null;
    }


    @GetMapping("/source")
    public List getAllFromSource() {
        KinghostAPI kinghostAPI = new KinghostAPI();
        JSONArray allStates = kinghostAPI.get(KinghostAPI.ALL_STATES_URL);


        this.insertAll(processData(allStates).toList());

        return allStates.toList();
    }


    private JSONArray processData(JSONArray stateList){
        Map<String,String> keysHashMap = new StateKeys().getHashMap();
        JSONArray newJsonArray = new JSONArray();
        stateList.forEach( object -> {
            JSONObject jsonObject = (JSONObject) object;
            JSONObject newJsonObject = new JSONObject();
            jsonObject.keySet().forEach(key -> {
                if(keysHashMap.containsKey(key))
                    newJsonObject.put(keysHashMap.get(key),jsonObject.get(key));
            });
            Gson gson = new Gson();
            State state = gson.fromJson(newJsonObject.toString(), State.class);
            newJsonArray.put(state);
        });


        return newJsonArray;
    }
}
