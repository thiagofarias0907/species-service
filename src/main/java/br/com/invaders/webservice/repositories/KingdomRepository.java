package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KingdomRepository extends JpaRepository<Kingdom,Long> {
}
