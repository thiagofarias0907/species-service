package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.Occurrence;
import br.com.invaders.webservice.entities.Statistics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class OccurrenceControllerTest extends  OccurrenceController {

    private final double centralLat = -25.0000;
    private final double centralLon = -60.0000;
    private final double precision  = 0.1;

    @Test
    void getSpeciesWithNullFiltersTest() {
        //CT01
        assertEquals(new ArrayList<>(),getAllWithFilters(null,null,null));
    }

    @Test
    void getSpeciesKingdomFilterOnlyTest() {
        //CT02
        List<Occurrence> speciesResponse = getAllWithFilters(1l,null,null);
        assertNotNull(speciesResponse);
        assertTrue(speciesResponse.size() > 0);

        Occurrence specieOccurrence = speciesResponse.get(0);
        assertFalse(specieOccurrence.getSpecie().getScientificName().isBlank());
        assertFalse(specieOccurrence.getLatitude().isBlank());
        assertFalse(specieOccurrence.getLongitude().isBlank());
        assertFalse(specieOccurrence.getLatitudeDecimal().isBlank());
        assertFalse(specieOccurrence.getLongitudeDecimal().isBlank());
        assertNotNull(specieOccurrence.getMunicipio());
        assertNotNull(specieOccurrence.getState());
        assertNotNull(specieOccurrence.getLocation());
        assertNull(specieOccurrence.getProtectedArea());

    }

    @Test
    void getSpecieWithIdFilterTest() {
        //CT03
        List<Occurrence> speciesResponse = getAllWithFilters(1l,6l,null);
        assertNotNull(speciesResponse);
        assertTrue(speciesResponse.size() > 0);

        Occurrence specieOccurrence = speciesResponse.get(0);
        assertEquals("Aedes aegypti",specieOccurrence.getSpecie().getScientificName());
        assertEquals("23 05 58 S",specieOccurrence.getLatitude());
        assertEquals("51 56 38 W",specieOccurrence.getLongitude());
        assertEquals("-23,099444444444444444444444444",specieOccurrence.getLatitudeDecimal());
        assertEquals("-51,943888888888888888888888889",specieOccurrence.getLongitudeDecimal());
        assertEquals("Flórida",specieOccurrence.getMunicipio());
        assertEquals("Paraná",specieOccurrence.getState());
        assertEquals("Imóveis em ambiente urbano",specieOccurrence.getLocation());
        assertEquals(null,specieOccurrence.getProtectedArea());

    }


    @Test
    void getSpeciesStateFilterOnlyTest() {
        //CT04
        List<Occurrence> speciesResponse = getAllWithFilters(null,null,41l);
        assertNotNull(speciesResponse);
        assertTrue(speciesResponse.size() > 0);

        Occurrence specieOccurrence = speciesResponse.get(0);
        assertEquals("Abramites hypselonotus",specieOccurrence.getSpecie().getScientificName());
        assertEquals("24 42 11 S",specieOccurrence.getLatitude());
        assertEquals("54 19 57 W",specieOccurrence.getLongitude());
        assertEquals("-24,703055555555555555555555556",specieOccurrence.getLatitudeDecimal());
        assertEquals("-54,332500000000000000000000000",specieOccurrence.getLongitudeDecimal());
        assertEquals("Entre Rios do Oeste",specieOccurrence.getMunicipio());
        assertEquals("Paraná",specieOccurrence.getState());
        assertEquals("Usina Hidrelétrica de Itaipu - reservatório",specieOccurrence.getLocation());
        assertEquals(null,specieOccurrence.getProtectedArea());


    }

    @Test
    void getNearbyOccurrenceTest() {
        //CT05
        List<Occurrence> occurrences = getAllNearbyOccurrences(centralLat, centralLon,precision);
        assertNotNull(occurrences,"a lista de ocorrências não pode ser null");
        assertTrue(occurrences.size() > 0,"A lista não pode ser vazia");
        occurrences.forEach(occurrence -> {
            assertTrue(isNearby(occurrence.getLatitudeDecimal(),occurrence.getLongitudeDecimal()));
        });

    }

    /**
     * Calculate if the occurrences listed are beetween the latitude and longitude precision
     * @param latitude
     * @param longitude
     * @return
     */
    private boolean isNearby(String latitude, String longitude){

        if (latitude.isBlank() || longitude.isBlank())
            return false;

        double lat = Double.parseDouble(latitude.replace(',','.'));
        double lon = Double.parseDouble(longitude.replace(',','.'));

        if ( (lat - centralLat)/ centralLat > precision || (lat - centralLat)/ centralLat < -precision )
            return false;
        if ( (lon - centralLon)/ centralLon > precision || (lon - centralLon)/ centralLon < -precision )
            return false;

        return true;
    }

    @Test
    void testGetCountSpeciesOccurrences() throws JSONException {
        long specieId = 6l;
        long response = super.getCountSpeciesOccurrences(specieId);
        assertNotNull(response);
        assertTrue(response >= 0);
    }

    @Test
    void testGetCountKingdomOccurrences() throws JSONException {
        String kingdom = "Animalia";
        Long response = super.getCountKingdomOccurrences(kingdom);
        assertNotNull(response);
        assertTrue(response >= 0);
    }

    @Test
    void testGetCountFamilyOccurrences() throws JSONException {
        String family = "Fabaceae";
        long response = super.getCountFamilyOccurrences(family);
        assertNotNull(response);
        assertTrue(response >= 0);
    }

    @Test
    void testGetCountSpecieByStateOccurrences() throws JSONException {
        long specieId = 6l;
        String state = "Santa Catarina";
        long response = super.getCountSpeciesByStateOccurrences(specieId,state);
        assertNotNull(response);
        assertTrue(response >= 0);

    }
}