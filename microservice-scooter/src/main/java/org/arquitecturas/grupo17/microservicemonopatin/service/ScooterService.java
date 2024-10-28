package org.arquitecturas.grupo17.microservicemonopatin.service;

import org.arquitecturas.grupo17.microservicemonopatin.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicemonopatin.model.Scooter;
import org.arquitecturas.grupo17.microservicemonopatin.repository.ScooterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScooterService {
    private ScooterRepository scooterRepository;

    public ScooterService(ScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    public Scooter create(Scooter scooter) {
        return scooterRepository.save(scooter);
    }

    public Scooter findById(long id) {
        return scooterRepository.findById(id).orElseThrow();
    }

    public List<Scooter> findAll() {
        return scooterRepository.findAll();
    }

    public Scooter update(ScooterDTO scooterDto, long id) {
        Scooter scooter = this.findById(id);
        scooter.setX(scooterDto.getX());
        scooter.setY(scooterDto.getY());
        scooter.setState(scooterDto.getState());
        return scooterRepository.save(scooter);
    }

    public void delete(long id) {
        scooterRepository.deleteById(id);
    }


}
