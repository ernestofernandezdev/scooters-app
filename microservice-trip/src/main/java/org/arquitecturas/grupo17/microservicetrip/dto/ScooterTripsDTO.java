package org.arquitecturas.grupo17.microservicetrip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScooterTripsDTO {
    private Long scooterId;
    private Long tripCount;
}