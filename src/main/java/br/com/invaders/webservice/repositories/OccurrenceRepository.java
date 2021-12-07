package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OccurrenceRepository extends JpaRepository<Occurrence,Long> {


    List<Occurrence> findAllByScientificName(String scientific_name);
}
