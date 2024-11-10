package org.arquitecturas.grupo17.microservicegateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PauseDTO {
    private Timestamp start;
    private Timestamp end;
}
