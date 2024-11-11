package org.arquitecturas.grupo17.microservicetrip.repository;

import org.arquitecturas.grupo17.microservicetrip.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("select p from Price p where p.since < ?1 order by p.since desc limit 1")
    Price findActualPrice(Timestamp since);

    Price findBySinceBefore(Timestamp since);
}
