package org.arquitecturas.grupo17.microservicetrip.utils;

import org.arquitecturas.grupo17.microservicetrip.dto.PauseDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Pause;
import org.springframework.stereotype.Component;

@Component
public class PauseMapper {

    public PauseDTO toDTO(Pause pause){
        if(pause == null){
            return null;
        }
        return new PauseDTO(pause.getStart(), pause.getEnd());
    }

    public Pause toEntity(PauseDTO pauseDTO){
        if(pauseDTO == null){
            return null;
        }
        return new Pause(pauseDTO.getStart(), pauseDTO.getEnd());
    }

    public void updateEntityFromDTO(PauseDTO pauseDTO, Pause pause) {
        if (pauseDTO.getStart() != null) {
            pause.setStart(pauseDTO.getStart());
        }
        if (pauseDTO.getEnd() != null) {
            pause.setEnd(pauseDTO.getEnd());
        }
    }
}
