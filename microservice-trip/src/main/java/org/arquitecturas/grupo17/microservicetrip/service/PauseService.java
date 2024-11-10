package org.arquitecturas.grupo17.microservicetrip.service;

import org.arquitecturas.grupo17.microservicetrip.dto.PauseDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Pause;
import org.arquitecturas.grupo17.microservicetrip.repository.PauseRepository;
import org.arquitecturas.grupo17.microservicetrip.utils.PauseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PauseService {
    private PauseRepository pauseRepository;
    private PauseMapper pauseMapper;

    public PauseService(PauseRepository pauseRepository, PauseMapper pauseMapper) {
        this.pauseRepository = pauseRepository;
        this.pauseMapper = pauseMapper;
    }

    public void create(PauseDTO pauseDTO) {
        Pause pause = pauseMapper.toEntity(pauseDTO);
        pauseRepository.save(pause);
    }

    public PauseDTO findById(long id) {
        Pause pause = pauseRepository.findById(id).orElseThrow();
        return this.pauseMapper.toDTO(pause);
    }

    public List<PauseDTO> findAll() {
        return pauseRepository.findAll().stream()
                .map(this.pauseMapper::toDTO)
                .toList();
    }

    public void update(PauseDTO pauseDTO, long id) {
        Pause pause = this.pauseRepository.findById(id).orElseThrow();
        this.pauseMapper.updateEntityFromDTO(pauseDTO, pause);
        pauseRepository.save(pause);
    }

    public void delete(long id) {
        pauseRepository.deleteById(id);
    }



}
