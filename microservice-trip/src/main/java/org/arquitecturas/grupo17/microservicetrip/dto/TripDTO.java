package org.arquitecturas.grupo17.microservicetrip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {
    private long userId;
    private long scooterId;
    private int distance;
    private Timestamp start;
    private Timestamp end;
    private PauseDTO pauseDTO;

    public TripDTO(long userId, long scooterId, int distance, Timestamp start, Timestamp end) {
        this.userId = userId;
        this.scooterId = scooterId;
        this.distance = distance;
        this.start = start;
        this.end = end;
    }
}
