package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.Occurrence;
import br.com.invaders.webservice.repositories.OccurrenceRepository;
import net.minidev.json.JSONArray;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class OccurrenceControllerTest extends  OccurrenceController {

    @Test
    void getSpeciesWithNullFiltersTest() {
        //CT01
        assertEquals(new JSONArray(),getAllWithFilters(null,null,null));
    }

    @Test
    void getSpeciesKingdomFilterOnlyTest() {
        //CT02
        List<Occurrence> speciesResponse = getAllWithFilters(1l,null,null);
        assertNotNull(speciesResponse);
        assertTrue(speciesResponse.size() > 0);

        Occurrence specieOccurrence = speciesResponse.get(0);
        assertFalse(specieOccurrence.getScientificName().isBlank());
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
        assertEquals("Aedes aegypti",specieOccurrence.getScientificName());
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
        assertEquals("Abramites hypselonotus",specieOccurrence.getScientificName());
        assertEquals("24 42 11 S",specieOccurrence.getLatitude());
        assertEquals("54 19 57 W",specieOccurrence.getLongitude());
        assertEquals("-24,703055555555555555555555556",specieOccurrence.getLatitudeDecimal());
        assertEquals("-54,332500000000000000000000000",specieOccurrence.getLongitudeDecimal());
        assertEquals("Entre Rios do Oeste",specieOccurrence.getMunicipio());
        assertEquals("Paraná",specieOccurrence.getState());
        assertEquals("Usina Hidrelétrica de Itaipu - reservatório",specieOccurrence.getLocation());
        assertEquals(null,specieOccurrence.getProtectedArea());


    }
}