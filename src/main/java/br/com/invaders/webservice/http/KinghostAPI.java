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
    public static final String ALL_STATES_URL = "http://www.api-bd.kinghost.net/api/VocStates/getall?PageSize=50";
    public static final String ALL_MUNICIPALITIES_URL = "http://www.api-bd.kinghost.net/api/Specie/getallwithcommomnames";
    public static final String ALL_KINGDOMS_URL = "http://www.api-bd.kinghost.net/api/TaxonomyKingdom/getall";
    public static final String ALL_OCCURRENCES_URL = "http://www.api-bd.kinghost.net/api/ExportData/especiesocorrenciasexport";

    public JSONArray get(String url, Parameter parameter) {

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
            if (response.body().startsWith("{")) {
                JSONObject responseBody = new JSONObject(response.body());
                if (responseBody.has("items"))
                    return ((JSONArray) responseBody.get("items"));
                return new JSONArray().put(responseBody);
            }

            return new JSONArray(response.body());
        }
        return new JSONArray();
    }

    public JSONArray get(String url) {

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (response.statusCode() == 200) {
            if (response.body().startsWith("{")) {
                JSONObject responseBody = new JSONObject(response.body());
                if (responseBody.has("items"))
                    return ((JSONArray) responseBody.get("items"));
                return new JSONArray().put(responseBody);
            }

            return new JSONArray(response.body());
        }
        return new JSONArray();
    }
}
