package org.arquitecturas.grupo17.microservicescooter.service;

import org.arquitecturas.grupo17.microservicescooter.dto.ScooterDTO;
import org.arquitecturas.grupo17.microservicescooter.model.Scooter;
import org.arquitecturas.grupo17.microservicescooter.repository.ScooterRepository;
import org.arquitecturas.grupo17.microservicescooter.utils.ScooterMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScooterService{

    private final ScooterRepository scooterRepository;
    private final ScooterMapper scooterMapper;

    public ScooterService(ScooterRepository scooterRepository, ScooterMapper scooterMapper) {
        this.scooterRepository = scooterRepository;
        this.scooterMapper = scooterMapper;
    }

    public void create(ScooterDTO scooterDTO) {
        Scooter scooter = scooterMapper.toEntity(scooterDTO);
        scooterRepository.save(scooter);
    }

    public ScooterDTO findById(Long id) {
        Scooter scooter = scooterRepository.findById(id).orElseThrow();
        return this.scooterMapper.toDTO(scooter);
    }

    public List<ScooterDTO> findAll() {
        return scooterRepository.findAll().stream()
                .map(this.scooterMapper::toDTO)
                .toList();
    }

    public void update(ScooterDTO scooterDto, Long id) {
        Scooter scooter = this.scooterRepository.findById(id).orElseThrow();
        this.scooterMapper.updateEntityFromDTO(scooterDto, scooter);
        scooterRepository.save(scooter);
    }

    public void delete(Long id) {
        scooterRepository.deleteById(id);
    }

    public void setScooterMaintenance(long scooterId) {
        try {
            Scooter scooter = scooterRepository.findById(scooterId).orElseThrow();
            scooter.setState(Scooter.MAINTENANCE);
            scooterRepository.save(scooter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void endScooterMaintenance(long scooterId) {
        try {
            Scooter scooter = scooterRepository.findById(scooterId).orElseThrow();
            scooter.setState(Scooter.AVAILABLE);
            scooterRepository.save(scooter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
