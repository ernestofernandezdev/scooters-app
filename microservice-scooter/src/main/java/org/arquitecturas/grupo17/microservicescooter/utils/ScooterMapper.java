package org.arquitecturas.grupo17.microservicescooter.utils;

import lombok.NoArgsConstructor;
import org.arquitecturas.grupo17.microservicescooter.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicescooter.model.Scooter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class ScooterMapper {

    public ScooterDTO toDTO(Scooter scooter){
        if(scooter == null){
            return null;
        }
        return new ScooterDTO(scooter.getState(), scooter.getX(), scooter.getY());
    }

    public Scooter toEntity(ScooterDTO scooterDTO){
        if(scooterDTO == null){
            return null;
        }
        return new Scooter(scooterDTO.getState(), scooterDTO.getX(), scooterDTO.getY());
    }

    public void updateEntityFromDTO(ScooterDTO scooterDTO, Scooter scooter) {
        if (scooterDTO.getX() != null) {
            scooter.setX(scooterDTO.getX());
        }
        if (scooterDTO.getY() != null) {
            scooter.setY(scooterDTO.getY());
        }
        if (scooterDTO.getState() != null) {
            scooter.setState(scooterDTO.getState());
        }
    }
}
