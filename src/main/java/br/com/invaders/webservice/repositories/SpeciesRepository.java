package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.Specie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Specie,Long> {

//    List<Specie> findAllByScientificName(String scientificName);


    @Transactional
    List<Specie> findByKingdomId(Long kingdomId);

    @Transactional
    List<Specie> findByKingdom(String kingdom);

    Specie findByScientificName(String scientificName);


}
