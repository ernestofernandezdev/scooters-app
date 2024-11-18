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
    public static int PENALTY_TIME = 15;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tripId;
    private long userId;
    private long scooterId;
    private int distance;
    private Timestamp start;
    private Timestamp end;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
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

    public long getPrice(Price price) {
        if (end == null) {
            return 0;
        } else if (pause != null && pause.isPenalized()) {
            long normalPriceTime = this.pause.getStart().getTime() + Trip.PENALTY_TIME*(60*1000)-this.start.getTime();
            long penaltyPriceTime = this.getEnd().getTime() - this.getStart().getTime() - normalPriceTime;
            long precio = price.getPrice() * normalPriceTime / (60 * 1000) + price.getPenaltyPrice() * penaltyPriceTime / (60 * 1000);
            return precio;
        } else {
            long time = this.end.getTime() - this.start.getTime();
            return price.getPrice()*time/(60*1000);
        }
    }

}
