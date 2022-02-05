package br.com.invaders.webservice.controller;

import br.com.invaders.webservice.entities.Statistics;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
class StatisticsControllerTest extends StatisticsController {

    @Test
    void testGetSpecieStatistics() throws JSONException {
        long specieId = 6l;
        List<Statistics> response = super.getSpecieStatistics(specieId);
        JSONObject jsonObject = new JSONObject(response.get(0).toString());
        assertTrue(jsonObject.has("species_id"));
        assertTrue(jsonObject.has("scientific_name"));
        assertTrue(jsonObject.has("kingdom_id"));
        assertTrue(jsonObject.has("kingdom"));
        assertTrue(jsonObject.has("family"));
        assertTrue(jsonObject.has("total_especie"));
        assertTrue(jsonObject.has("total_reino"));
        assertTrue(jsonObject.has("total_familia"));
        assertTrue(jsonObject.has("Acre"));
        assertTrue(jsonObject.has("Alagoas"));
        assertTrue(jsonObject.has("Amapá"));
        assertTrue(jsonObject.has("Amazonas"));
        assertTrue(jsonObject.has("Bahia"));
        assertTrue(jsonObject.has("Ceara"));
        assertTrue(jsonObject.has("Distrito_Federal"));
        assertTrue(jsonObject.has("Espírito_Santo"));
        assertTrue(jsonObject.has("Goiás"));
        assertTrue(jsonObject.has("Maranhão"));
        assertTrue(jsonObject.has("Mato_Grosso"));
        assertTrue(jsonObject.has("Mato_Grosso_do_Sul"));
        assertTrue(jsonObject.has("Minas_Gerais"));
        assertTrue(jsonObject.has("Pará"));
        assertTrue(jsonObject.has("Paraíba"));
        assertTrue(jsonObject.has("Paraná"));
        assertTrue(jsonObject.has("Pernambuco"));
        assertTrue(jsonObject.has("Piauí"));
        assertTrue(jsonObject.has("Rio_de_Janeiro"));
        assertTrue(jsonObject.has("Rio_Grande_do_Norte"));
        assertTrue(jsonObject.has("Rio_Grande_do_Sul"));
        assertTrue(jsonObject.has("Rondônia"));
        assertTrue(jsonObject.has("Roraima"));
        assertTrue(jsonObject.has("Santa_Catarina"));
        assertTrue(jsonObject.has("São_Paulo"));
        assertTrue(jsonObject.has("Sergipe"));
        assertTrue(jsonObject.has("Tocantins"));
    }
}
