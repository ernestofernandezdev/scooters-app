package org.arquitecturas.grupo17.microservicemonopatin.service;

import org.arquitecturas.grupo17.microservicemonopatin.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicemonopatin.model.Scooter;
import org.arquitecturas.grupo17.microservicemonopatin.repository.ScooterRepository;
import org.arquitecturas.grupo17.microservicemonopatin.utils.ScooterMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScooterServiceImpl implements ScooterService{

    private final ScooterRepository scooterRepository;
    private final ScooterMapper scooterMapper = new ScooterMapper();

    public ScooterServiceImpl(ScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    public Scooter create(ScooterDTO scooterDTO) {
        Scooter scooter = scooterMapper.toEntity(scooterDTO);
        return scooterRepository.save(scooter);
    }

    public Scooter findById(Long id) {
        return scooterRepository.findById(id).orElseThrow();
    }

    public List<Scooter> findAll() {
        return scooterRepository.findAll();
    }

    public Scooter update(ScooterDTO scooterDto, Long id) {
        Scooter scooter = this.findById(id);
        if (scooter == null) {
            return null;
        }
        this.scooterMapper.updateEntityFromDTO(scooterDto, scooter);
        return scooterRepository.save(scooter);
    }

    public void delete(Long id) {
        scooterRepository.deleteById(id);
    }

}
