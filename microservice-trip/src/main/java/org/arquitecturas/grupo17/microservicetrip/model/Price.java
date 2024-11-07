package org.arquitecturas.grupo17.microservicetrip.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPrice;
    private Timestamp since;
    private int price;
    private int penaltyPrice;

    public Price(Timestamp since, int price, int penaltyPrice) {
        this.since = since;
        this.price = price;
        this.penaltyPrice = penaltyPrice;
    }
}
