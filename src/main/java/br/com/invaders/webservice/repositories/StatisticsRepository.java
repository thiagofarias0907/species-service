package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticsRepository  extends JpaRepository<Statistics,Long> {


    @Query(value = "WITH origin AS (\n" +
            "SELECT \n" +
            "  DISTINCT s.species_id , o.scientific_name,  s.kingdom_id, s.kingdom, s.family, o.state, \n" +
            "  count(1) OVER (PARTITION BY o.scientific_name) AS total_especie,\n" +
            "  count(s.kingdom) OVER (PARTITION BY s.kingdom_id) AS total_reino,\n" +
            "  count(s.family) OVER (PARTITION BY s.family) AS total_familia,\n" +
            "  count(o.state) OVER (PARTITION BY o.state, o.scientific_name) AS total_especie_estado\n" +
            " FROM \n" +
            "  occurrence o\n" +
            "  LEFT JOIN specie s ON s.scientific_name  = o.scientific_name )\n" +
            "  \n" +
            "SELECT \n" +
            "  DISTINCT species_id , scientific_name,  kingdom_id, kingdom, statistics.family,total_especie,total_reino,total_familia\n" +
            ",sum(CASE WHEN state = 'Acre'                THEN total_especie_estado else 0 end) as  Acre\n" +
            ",sum(CASE WHEN state = 'Alagoas'             THEN total_especie_estado else 0 end) as  Alagoas\n" +
            ",sum(CASE WHEN state = 'Amapá'               THEN total_especie_estado else 0 end) as  Amapá\n" +
            ",sum(CASE WHEN state = 'Amazonas'            THEN total_especie_estado else 0 end) as  Amazonas\n" +
            ",sum(CASE WHEN state = 'Bahia'               THEN total_especie_estado else 0 end) as  Bahia\n" +
            ",sum(CASE WHEN state = 'Ceara'               THEN total_especie_estado else 0 end) as  Ceara\n" +
            ",sum(CASE WHEN state = 'Distrito Federal'    THEN total_especie_estado else 0 end) as  Distrito_Federal\n" +
            ",sum(CASE WHEN state = 'Espírito Santo'      THEN total_especie_estado else 0 end) as  Espírito_Santo\n" +
            ",sum(CASE WHEN state = 'Goiás'               THEN total_especie_estado else 0 end) as  Goiás\n" +
            ",sum(CASE WHEN state = 'Maranhão'            THEN total_especie_estado else 0 end) as  Maranhão\n" +
            ",sum(CASE WHEN state = 'Mato Grosso'         THEN total_especie_estado else 0 end) as  Mato_Grosso\n" +
            ",sum(CASE WHEN state = 'Mato Grosso do Sul'  THEN total_especie_estado else 0 end) as  Mato_Grosso_do_Sul\n" +
            ",sum(CASE WHEN state = 'Minas Gerais'        THEN total_especie_estado else 0 end) as  Minas_Gerais\n" +
            ",sum(CASE WHEN state = 'Pará'                THEN total_especie_estado else 0 end) as  Pará\n" +
            ",sum(CASE WHEN state = 'Paraíba'             THEN total_especie_estado else 0 end) as  Paraíba\n" +
            ",sum(CASE WHEN state = 'Paraná'              THEN total_especie_estado else 0 end) as  Paraná\n" +
            ",sum(CASE WHEN state = 'Pernambuco'          THEN total_especie_estado else 0 end) as  Pernambuco\n" +
            ",sum(CASE WHEN state = 'Piauí'               THEN total_especie_estado else 0 end) as  Piauí\n" +
            ",sum(CASE WHEN state = 'Rio de Janeiro'      THEN total_especie_estado else 0 end) as  Rio_de_Janeiro\n" +
            ",sum(CASE WHEN state = 'Rio Grande do Norte' THEN total_especie_estado else 0 end) as  Rio_Grande_do_Norte\n" +
            ",sum(CASE WHEN state = 'Rio Grande do Sul'   THEN total_especie_estado else 0 end) as  Rio_Grande_do_Sul\n" +
            ",sum(CASE WHEN state = 'Rondônia'            THEN total_especie_estado else 0 end) as  Rondônia\n" +
            ",sum(CASE WHEN state = 'Roraima'             THEN total_especie_estado else 0 end) as  Roraima\n" +
            ",sum(CASE WHEN state = 'Santa Catarina'      THEN total_especie_estado else 0 end) as  Santa_Catarina\n" +
            ",sum(CASE WHEN state = 'São Paulo'           THEN total_especie_estado else 0 end) as  São_Paulo\n" +
            ",sum(CASE WHEN state = 'Sergipe'             THEN total_especie_estado else 0 end) as  Sergipe\n" +
            ",sum(CASE WHEN state = 'Tocantins'           THEN total_especie_estado else 0 end) as  Tocantins  \n" +
            "FROM  origin as statistics \n" +
            "WHERE statistics.species_id = :specieId\n" +
            "GROUP BY 1,2,3,4,5,6,7,8", nativeQuery = true)
    List<Statistics> getSpecieStatistics(Long specieId);
}
