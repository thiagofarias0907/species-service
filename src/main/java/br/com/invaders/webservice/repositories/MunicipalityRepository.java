package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality,Long> {
}
