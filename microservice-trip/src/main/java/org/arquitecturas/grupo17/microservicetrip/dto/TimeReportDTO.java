package org.arquitecturas.grupo17.microservicetrip.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeReportDTO {
    private Long scooterId;
    private Long time;

    public TimeReportDTO(Long scooterId, Long time) {
        this.scooterId = scooterId;
        this.time = time;
    }

    public void addTime(Long time) {
        this.time += time;
    }

    public void subtractTime(Long time) {
        this.time -= time;
    }

}
