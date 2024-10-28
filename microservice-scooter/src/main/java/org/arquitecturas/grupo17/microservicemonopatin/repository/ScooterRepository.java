package org.arquitecturas.grupo17.microservicemonopatin.repository;

import org.arquitecturas.grupo17.microservicemonopatin.model.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {

}
