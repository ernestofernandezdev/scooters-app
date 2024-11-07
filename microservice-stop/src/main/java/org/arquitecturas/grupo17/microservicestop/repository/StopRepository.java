package org.arquitecturas.grupo17.microservicestop.repository;

import org.arquitecturas.grupo17.microservicestop.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
}
