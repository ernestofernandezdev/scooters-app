package org.arquitecturas.grupo17.microservicetrip.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class Pause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pauseId;
    private Timestamp start;
    private Timestamp end;
    @OneToOne
    private Trip trip;

    public Pause(Timestamp start, Timestamp end) {
        this.start = start;
        this.end = end;
    }

    public Pause() {
        this.start = Timestamp.valueOf(LocalDateTime.now());
    }
}
