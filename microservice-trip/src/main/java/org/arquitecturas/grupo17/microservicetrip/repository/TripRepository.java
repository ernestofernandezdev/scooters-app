package org.arquitecturas.grupo17.microservicetrip.repository;

import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
