package org.arquitecturas.grupo17.microservicegateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeReportDTO {
    private Long scooterId;
    private Long time;

    public TimeReportDTO(long scooterId, Long time) {
        this.scooterId = scooterId;
        this.time = time;
    }

}
