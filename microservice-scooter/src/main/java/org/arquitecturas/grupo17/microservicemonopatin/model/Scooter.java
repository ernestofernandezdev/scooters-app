package org.arquitecturas.grupo17.microservicemonopatin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Scooter {
    public static final int AVAILABLE = 0;
    public static final int IN_USE = 1;
    public static final int MAINTENANCE = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    int state;
    int x;
    int y;


}
