package org.arquitecturas.grupo17.microservicetrip.service;

import org.arquitecturas.grupo17.microservicetrip.dto.TripDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.arquitecturas.grupo17.microservicetrip.repository.TripRepository;
import org.arquitecturas.grupo17.microservicetrip.utils.TripMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private TripRepository tripRepository;
    private TripMapper tripMapper;

    public TripService(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    public void create(TripDTO tripDTO) {
        Trip trip = tripMapper.toEntity(tripDTO);
        tripRepository.save(trip);
    }

    public TripDTO findById(long id) {
        Trip trip = tripRepository.findById(id).orElseThrow();
        return this.tripMapper.toDTO(trip);
    }

    public List<TripDTO> findAll() {
        return tripRepository.findAll().stream()
                .map(this.tripMapper::toDTO)
                .toList();
    }

    public void update(TripDTO tripDTO, long id) {
        Trip trip = this.tripRepository.findById(id).orElseThrow();
        this.tripMapper.updateEntityFromDTO(tripDTO, trip);
        tripRepository.save(trip);
    }

    public void delete(long id) {
        tripRepository.deleteById(id);
    }

}
