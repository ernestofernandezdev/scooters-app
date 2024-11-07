package org.arquitecturas.grupo17.microservicetrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tripId;
    private long userId;
    private long scooterId;
    private int distance;
    private Timestamp start;
    private Timestamp end;
    @OneToOne(mappedBy = "trip", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Pause pause;

    public Trip(long userId, long scooterId, int distance, Timestamp start, Timestamp end) {
        this.userId = userId;
        this.scooterId = scooterId;
        this.distance = distance;
        this.start = start;
        this.end = end;
    }

    public Trip(long userId, long scooterId, int distance) {
        this.userId = userId;
        this.scooterId = scooterId;
        this.distance = distance;
        this.start = Timestamp.valueOf(LocalDateTime.now());
    }

}
