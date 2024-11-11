package org.arquitecturas.grupo17.microservicetrip.repository;

import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("SELECT t.scooterId, COUNT(t) FROM Trip t WHERE YEAR(t.start) = ?1 GROUP BY t.scooterId HAVING COUNT(t) > ?2")
    List<Object[]> findScootersWithMoreThanXTripsInYear(int year, long minTrips);

    List<Trip> findByStartBetween(Timestamp start, Timestamp end);

}
