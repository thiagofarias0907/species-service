package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.Kingdom;
import br.com.invaders.webservice.entities.State;
import br.com.invaders.webservice.http.KinghostAPI;
import br.com.invaders.webservice.repositories.KingdomRepository;
import br.com.invaders.webservice.repositories.StateRepository;
import br.com.invaders.webservice.utils.KingdomKeys;
import br.com.invaders.webservice.utils.StateKeys;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/kingdoms")
public class KingdomController implements Controller {

    @Autowired
    KingdomRepository kingdomRepository;

    @GetMapping("")
    @Override
    public List getAll() {
        return this.kingdomRepository.findAll();
    }

    @GetMapping("{id}")
    public Object getById(@PathVariable Long id) {
        return this.kingdomRepository.findById(id);
    }

    @PostMapping("")
    @Override
    public List insertAll(List list) {
        return this.kingdomRepository.saveAll(list);
    }

    @GetMapping("/stats")
    @Override
    public JSONObject getEstatisticas() {
        return null;
    }


    @GetMapping("/source")
    public List getAllFromSource() {
        KinghostAPI kinghostAPI = new KinghostAPI();
        JSONArray allKingdoms = kinghostAPI.get(KinghostAPI.ALL_KINGDOMS_URL);


        this.insertAll(processData(allKingdoms).toList());

        return allKingdoms.toList();
    }


    private JSONArray processData(JSONArray kingdomList){
        Map<String,String> keysHashMap = new KingdomKeys().getHashMap();
        JSONArray newJsonArray = new JSONArray();
        kingdomList.forEach( object -> {
            JSONObject jsonObject = (JSONObject) object;
            JSONObject newJsonObject = new JSONObject();
            jsonObject.keySet().forEach(key -> {
                if(keysHashMap.containsKey(key))
                    newJsonObject.put(keysHashMap.get(key),jsonObject.get(key));
            });
            Gson gson = new Gson();
            Kingdom kingdom = gson.fromJson(newJsonObject.toString(), Kingdom.class);
            newJsonArray.put(kingdom);
        });


        return newJsonArray;
    }
}
