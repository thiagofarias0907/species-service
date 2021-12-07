package br.com.invaders.webservice.repositories;

import br.com.invaders.webservice.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
