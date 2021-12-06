package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.Specie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Specie,Long> {

    List<Specie> findAllByScientificName(String scientificName);


}
