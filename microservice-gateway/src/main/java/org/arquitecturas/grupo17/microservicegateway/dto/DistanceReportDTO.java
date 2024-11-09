package org.arquitecturas.grupo17.microservicegateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistanceReportDTO {
    private long scooterId;
    private long distance;
}
