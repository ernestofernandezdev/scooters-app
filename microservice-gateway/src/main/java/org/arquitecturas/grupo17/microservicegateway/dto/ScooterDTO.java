package org.arquitecturas.grupo17.microservicegateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScooterDTO {
    Integer x;
    Integer y;
    Integer state;
}
