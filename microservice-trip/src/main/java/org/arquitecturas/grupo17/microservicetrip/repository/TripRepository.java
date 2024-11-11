package org.arquitecturas.grupo17.microservicetrip.repository;

import org.arquitecturas.grupo17.microservicetrip.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.TimeReportDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("""
            select new org.arquitecturas.grupo17.microservicetrip.dto.DistanceReportDTO(
                t.scooterId,
                sum(t.distance)
            )
            from Trip t
            group by t.scooterId
""")
    List<DistanceReportDTO> getDistanceReport();

    @Query("""
            select
                t.scooterId,
                t.start,
                t.end
            from Trip t
            where t.end is not null
            order by t.scooterId
""")
    List<Object[]> getTimeWithStopsReport();

    @Query("SELECT t.scooterId, COUNT(t) FROM Trip t WHERE YEAR(t.start) = ?1 GROUP BY t.scooterId HAVING COUNT(t) >= ?2")
    List<Object[]> findScootersWithMoreThanXTripsInYear(int year, long minTrips);

    List<Trip> findByStartBetween(Timestamp start, Timestamp end);

}
