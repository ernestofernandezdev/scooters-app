package org.arquitecturas.grupo17.microservicetrip.repository;

import org.arquitecturas.grupo17.microservicetrip.model.Pause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PauseRepository extends JpaRepository<Pause, Long> {
}
