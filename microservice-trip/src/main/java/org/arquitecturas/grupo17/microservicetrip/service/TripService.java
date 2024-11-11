package org.arquitecturas.grupo17.microservicetrip.service;

import org.arquitecturas.grupo17.microservicetrip.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.TimeReportDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.TripDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.arquitecturas.grupo17.microservicetrip.repository.PauseRepository;
import org.arquitecturas.grupo17.microservicetrip.repository.TripRepository;
import org.arquitecturas.grupo17.microservicetrip.utils.TripMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class TripService {
    private TripRepository tripRepository;
    private PauseRepository pauseRepository;
    private TripMapper tripMapper;

    public TripService(TripRepository tripRepository, PauseRepository pauseRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.pauseRepository = pauseRepository;
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

    public List<DistanceReportDTO> getDistanceReport() {
        return this.tripRepository.getDistanceReport();
    }

    public List<TimeReportDTO> getTimeReport(boolean withPauses) {
        List<Object[]> rows = this.tripRepository.getTimeWithStopsReport();

        try {

            HashMap<Long, TimeReportDTO> reports = new HashMap<>();
            long scooterId = (long) rows.getFirst()[0];
            TimeReportDTO timeReportDTO = new TimeReportDTO(scooterId,0L);
            for (Object[] row : rows) {
                long time = (((Timestamp) row[2]).getTime() - ((Timestamp) row[1]).getTime())/60000;

                if ((long) row[0] != scooterId) {
                    reports.put(scooterId, timeReportDTO);
                    scooterId = (long) row[0];
                    timeReportDTO = new TimeReportDTO(scooterId,0L);
                }

                timeReportDTO.addTime(time);
            }

            reports.put(scooterId, timeReportDTO);

            if (!withPauses) {
                List<Object[]> pauses = this.pauseRepository.getPauses();
                for (Object[] row : pauses) {
                    long pauseTime = (((Timestamp) row[2]).getTime() - ((Timestamp) row[1]).getTime())/60000;
                    reports.get((Long) row[0]).subtractTime(pauseTime);
                }
            }

            return new ArrayList<>(reports.values());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
