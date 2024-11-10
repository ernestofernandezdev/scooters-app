package org.arquitecturas.grupo17.microservicescooter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scooter {
    public static final int AVAILABLE = 0;
    public static final int IN_USE = 1;
    public static final int MAINTENANCE = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer state;
    private Integer x;
    private Integer y;

    public Scooter(Integer state, Integer x, Integer y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }
}
