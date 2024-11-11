package org.arquitecturas.grupo17.microservicescooter.repository;

import org.arquitecturas.grupo17.microservicescooter.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicescooter.dto.ScooterStateDTO;
import org.arquitecturas.grupo17.microservicescooter.model.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {

    @Query("""
    select new org.arquitecturas.grupo17.microservicescooter.dto.ScooterStateDTO(s.state, count(s))
    from Scooter s
    group by s.state
""")
    List<ScooterStateDTO> findPerState();

    @Query("""
            select new org.arquitecturas.grupo17.microservicescooter.dto.ScooterDTO(s.x, s.y, s.state)
            from Scooter s
            where s.x between (:userX-:distance) and (:userX+:distance)
            and s.y between (:userY-:distance) and (:userY+:distance)
""")
    List<ScooterDTO> findCloseScooters(int distance, int userX, int userY);

}
