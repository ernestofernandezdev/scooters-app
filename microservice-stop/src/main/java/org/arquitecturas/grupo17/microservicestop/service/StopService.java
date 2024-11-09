package org.arquitecturas.grupo17.microservicestop.service;

import org.arquitecturas.grupo17.microservicestop.dto.StopDTO;
import org.arquitecturas.grupo17.microservicestop.model.Stop;
import org.arquitecturas.grupo17.microservicestop.repository.StopRepository;
import org.arquitecturas.grupo17.microservicestop.utils.StopMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService {

    private final StopRepository stopRepository;
    private final StopMapper stopMapper = new StopMapper();

    public StopService(StopRepository stopRepository){
        this.stopRepository = stopRepository;
    }

    public void create(StopDTO stopDTO){
        Stop stop = stopMapper.toEntity(stopDTO);
        this.stopRepository.save(stop);
    }

    public StopDTO findById(long id) {
        return this.stopMapper.toDTO(stopRepository.findById(id).orElseThrow());
    }

    public List<StopDTO> findAll() {
        return this.stopRepository.findAll().stream()
                .map(this.stopMapper::toDTO)
                .toList();
    }

    public void update(StopDTO stopDTO, long id) {
        Stop stop = this.stopRepository.findById(id).orElseThrow();
        this.stopMapper.updateEntityFromDTO(stopDTO, stop);
        this.stopRepository.save(stop);
    }

    public void delete(long id) {
        this.stopRepository.deleteById(id);
    }
}
