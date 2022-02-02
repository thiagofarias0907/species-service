package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OccurrenceRepository extends JpaRepository<Occurrence,Long> {
//
//    List<Occurrence> findAllByScientificName(String scientific_name);
//
//    List<Occurrence> findAllByScientificNameAndState(String scientific_name, String state);

    List<Occurrence> findAllBySpecie_scientificName(String scientific_name);

    List<Occurrence> findAllBySpecie_scientificNameAndState(String scientific_name, String state);

    List<Occurrence> findAllByState(String state);

    @Query(value = "SELECT o FROM Occurrence o " +
            " WHERE scientific_name in :species" +
            " AND state = :state ")
    List<Occurrence> findFromSpeciesAndState(@Param("species") List<String> species, @Param("state") String state);


    @Query(value = "SELECT o FROM Occurrence o " +
            " WHERE scientific_name in :species")
    List<Occurrence> findFromSpecies(@Param("species") List<String> species);

    List<Occurrence> findAll();

    @Query(value = "SELECT o FROM Occurrence o " +
            "WHERE (CAST(regexp_replace(latitude_decimal,',','.') AS double) - :latitude )/:latitude  between - :precision AND :precision " +
            "  AND (CAST(regexp_replace(longitude_decimal,',','.') AS double) - :longitude)/:longitude between - :precision AND :precision")
    List<Occurrence> findAllNearby(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("precision") double precision);

}
