package org.arquitecturas.grupo17.microservicemonopatin.service;

import org.arquitecturas.grupo17.microservicemonopatin.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicemonopatin.model.Scooter;

import java.util.List;

public interface ScooterService {
    Scooter create(ScooterDTO scooterDTO);
    Scooter findById(Long id);
    List<Scooter> findAll();
    Scooter update(ScooterDTO scooterDTO, Long id);
    void delete(Long id);
}
