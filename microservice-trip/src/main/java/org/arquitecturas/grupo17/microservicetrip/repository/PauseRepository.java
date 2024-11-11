package org.arquitecturas.grupo17.microservicetrip.repository;

import org.arquitecturas.grupo17.microservicetrip.model.Pause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PauseRepository extends JpaRepository<Pause, Long> {

    @Query("""
            select t.scooterId, p.start, p.end
            from Pause p join p.trip t
            where p.end is not null
            and t.end is not null
            and p.trip is not null
            order by t.scooterId
            """)
    List<Object[]> getPauses();
}
