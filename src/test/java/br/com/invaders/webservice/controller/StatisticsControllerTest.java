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
        Statistics response = super.getSpecieStatistics(specieId);
        JSONObject jsonObject = new JSONObject(response.toString());
        assertTrue(jsonObject.has("species_id"));
        assertTrue(jsonObject.has("scientific_name"));
        assertTrue(jsonObject.has("kingdom_id"));
        assertTrue(jsonObject.has("kingdom"));
        assertTrue(jsonObject.has("family"));
        assertTrue(jsonObject.has("total_especie"));
        assertTrue(jsonObject.has("total_reino"));
        assertTrue(jsonObject.has("total_familia"));
        assertTrue(jsonObject.has("acre"));
        assertTrue(jsonObject.has("alagoas"));
        assertTrue(jsonObject.has("amapa"));
        assertTrue(jsonObject.has("amazonas"));
        assertTrue(jsonObject.has("bahia"));
        assertTrue(jsonObject.has("ceara"));
        assertTrue(jsonObject.has("distrito_Federal"));
        assertTrue(jsonObject.has("espirito_Santo"));
        assertTrue(jsonObject.has("goias"));
        assertTrue(jsonObject.has("maranhao"));
        assertTrue(jsonObject.has("mato_Grosso"));
        assertTrue(jsonObject.has("mato_Grosso_do_Sul"));
        assertTrue(jsonObject.has("minas_Gerais"));
        assertTrue(jsonObject.has("para"));
        assertTrue(jsonObject.has("paraiba"));
        assertTrue(jsonObject.has("parana"));
        assertTrue(jsonObject.has("pernambuco"));
        assertTrue(jsonObject.has("piaui"));
        assertTrue(jsonObject.has("rio_de_Janeiro"));
        assertTrue(jsonObject.has("rio_Grande_do_Norte"));
        assertTrue(jsonObject.has("rio_Grande_do_Sul"));
        assertTrue(jsonObject.has("rondonia"));
        assertTrue(jsonObject.has("roraima"));
        assertTrue(jsonObject.has("santa_Catarina"));
        assertTrue(jsonObject.has("sao_Paulo"));
        assertTrue(jsonObject.has("sergipe"));
        assertTrue(jsonObject.has("tocantins"));
    }
}
