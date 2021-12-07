package br.com.invaders.webservice.utils;

import java.util.HashMap;
import java.util.Map;

public class OccurrenceKeys {


    Map<String,String> hashMap = new HashMap();

    public OccurrenceKeys() {
        hashMap.put("kingdom", "kingdom");
        hashMap.put("phyllum", "phyllum");
        hashMap.put("class", "class");
        hashMap.put("oorder", "oorder");
        hashMap.put("family", "family");
        hashMap.put("genus", "genus");
        hashMap.put("scientific_name", "scientificName");
        hashMap.put("author", "author");
        hashMap.put("latitude", "latitude");
        hashMap.put("longitude", "longitude");
        hashMap.put("latitude_decimal", "latitudeDecimal");
        hashMap.put("longitude_decimal", "longitudeDecimal");
        hashMap.put("datum", "datum");
        hashMap.put("zone", "zone");
        hashMap.put("band", "band");
//        hashMap.put("coord_unit", "coordUnit");
//        hashMap.put("coord_utm_x", "coordUtm_x");
//        hashMap.put("coord_utm_y", "coord_utm_y");
//        hashMap.put("data_source", "data_source");
        hashMap.put("location", "location");
        hashMap.put("protected_area", "protectedArea");
        hashMap.put("municipio", "municipio");
        hashMap.put("state", "state");
    }


    public Map<String, String> getHashMap() {
        return hashMap;
    }
}
