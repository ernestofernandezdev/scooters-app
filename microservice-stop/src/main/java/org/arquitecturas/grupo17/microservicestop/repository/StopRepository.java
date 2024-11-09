package org.arquitecturas.grupo17.microservicestop.repository;

import org.arquitecturas.grupo17.microservicestop.model.Stop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends MongoRepository<Stop, Long> {
}
