package org.arquitecturas.grupo17.microservicetrip.service;

import org.arquitecturas.grupo17.microservicetrip.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.TimeReportDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.TripDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.arquitecturas.grupo17.microservicetrip.repository.TripRepository;
import org.arquitecturas.grupo17.microservicetrip.utils.TripMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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

    public List<DistanceReportDTO> getDistanceReport() {
        return this.tripRepository.getDistanceReport();
    }

    public List<TimeReportDTO> getTimeReport(boolean stops) {
        if (stops) {
            List<Object[]> rows = this.tripRepository.getTimeWithStopsReport();
            System.out.println(rows.size());
            List<TimeReportDTO> reports = new ArrayList<>();
            long scooterId = (long) rows.getFirst()[0];
            TimeReportDTO timeReportDTO = new TimeReportDTO(scooterId,0L);
            for (Object[] row : rows) {
                long time = (((Timestamp) row[2]).getTime() - ((Timestamp) row[1]).getTime())/60000;

                if ((long) row[0] != scooterId) {
                    System.out.println(timeReportDTO.getTime());
                    reports.add(timeReportDTO);
                    scooterId = (long) row[0];
                    timeReportDTO = new TimeReportDTO(scooterId,0L);
                }

                timeReportDTO.addTime(time);
            }
            reports.add(timeReportDTO);

            return reports;
        } else {
            return null;
        }
    }

}
