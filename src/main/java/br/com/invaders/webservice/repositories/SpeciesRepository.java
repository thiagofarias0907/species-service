package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.Specie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Specie,Long> {

//    List<Specie> findAllByScientificName(String scientificName);

    @Query(value = "SELECT s from Specie s WHERE s.kingdomId = :kingdomId ")
    List<Specie> findByKingdomId(Long kingdomId);

    @Query(value = "SELECT s from Specie s WHERE s.kingdom = :kingdom ")
    List<Specie> findByKingdom(String kingdom);

    Specie findByScientificName(String scientificName);


}
