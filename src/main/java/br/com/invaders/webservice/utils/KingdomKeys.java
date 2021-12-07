package br.com.invaders.webservice.utils;

import java.util.HashMap;
import java.util.Map;

public class KingdomKeys {

    Map<String,String> hashMap = new HashMap();

    public KingdomKeys() {

        hashMap.put("kingdom_id","id");
        hashMap.put("kingdom","kingdom");
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }
}
