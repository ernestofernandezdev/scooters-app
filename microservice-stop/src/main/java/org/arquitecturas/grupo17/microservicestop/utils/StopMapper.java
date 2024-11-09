package org.arquitecturas.grupo17.microservicestop.utils;

import org.arquitecturas.grupo17.microservicestop.dto.StopDTO;
import org.arquitecturas.grupo17.microservicestop.model.Stop;

public class StopMapper {
    public StopDTO toDTO(Stop stop) {
        if (stop == null) {
            return null;
        }
        return new StopDTO(
                stop.getX(),
                stop.getY()
        );
    }

    public Stop toEntity(StopDTO stopDTO) {
        if (stopDTO == null) {
            return null;
        }
        return new Stop(
                stopDTO.getX(),
                stopDTO.getY()
        );
    }

    public void updateEntityFromDTO(StopDTO stopDTO, Stop stop) {
        if (stopDTO.getX() != null) {
            stop.setX(stopDTO.getX());
        }
        if (stopDTO.getY() != null) {
            stop.setY(stopDTO.getY());
        }
    }

}
