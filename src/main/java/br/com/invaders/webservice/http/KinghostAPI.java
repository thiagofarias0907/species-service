package br.com.invaders.webservice.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.com.invaders.webservice.parameters.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class KinghostAPI {

    public static final String ALL_SPECIES_URL = "http://www.api-bd.kinghost.net/api/Specie/getallwithcommomnames";
    public static final String ALL_STATES_URL = "http://www.api-bd.kinghost.net/api/Specie/getallwithcommomnames";
    public static final String ALL_MUNICIPALITIES_URL = "http://www.api-bd.kinghost.net/api/Specie/getallwithcommomnames";
    public static final String ALL_KINGDOMS_URL = "http://www.api-bd.kinghost.net/api/TaxonomyKingdom/getall";
    public static final String ALL_OCCURRENCES_URL = "http://www.api-bd.kinghost.net/api/Specie/getallwithcommomnames";

    public JSONArray get(String url, AllSpeciesParameter parameter) {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url+parameter)).GET().build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (response.statusCode() == 200) {
            JSONObject responseBody = new JSONObject(response.body());
            return ((JSONArray) responseBody.get("items"));
        }
        return new JSONArray();
    }
}
