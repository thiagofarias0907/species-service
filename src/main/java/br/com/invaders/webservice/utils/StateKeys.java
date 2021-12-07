package br.com.invaders.webservice.utils;

import java.util.HashMap;
import java.util.Map;

public class StateKeys {

    Map<String,String> hashMap = new HashMap();

    public StateKeys() {

        hashMap.put("state_id","id");
        hashMap.put("state","state");
        hashMap.put("uf","uf");
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }
}
