package org.arquitecturas.grupo17.microservicetrip.dto;

import lombok.Data;

@Data
public class TimeWithoutStopsReportDTO {
    private long scooterId;
    private String time;
}
