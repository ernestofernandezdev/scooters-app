package org.arquitecturas.grupo17.microservicetrip.repository;

import org.arquitecturas.grupo17.microservicetrip.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
                sum(t.end - t.start)
            from Trip t
            where t.end is not null
            group by t.scooterId
""")
    List<Object[]> getTimeWithoutStopsReport();
}
