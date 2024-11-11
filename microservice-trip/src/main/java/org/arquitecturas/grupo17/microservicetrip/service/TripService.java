package org.arquitecturas.grupo17.microservicetrip.service;

import org.arquitecturas.grupo17.microservicetrip.dto.DistanceReportDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.TimeReportDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.ScooterTripsDTO;
import org.arquitecturas.grupo17.microservicetrip.dto.TripDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Price;
import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.arquitecturas.grupo17.microservicetrip.repository.PauseRepository;
import org.arquitecturas.grupo17.microservicetrip.repository.PriceRepository;
import org.arquitecturas.grupo17.microservicetrip.repository.TripRepository;
import org.arquitecturas.grupo17.microservicetrip.utils.TripMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {
    private TripRepository tripRepository;
    private PauseRepository pauseRepository;
    private PriceRepository priceRepository;
    private TripMapper tripMapper;

    public TripService(TripRepository tripRepository, PriceRepository priceRepository, PauseRepository pauseRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.pauseRepository = pauseRepository;
        this.priceRepository = priceRepository;
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

    public List<ScooterTripsDTO> getScootersWithMoreThanXTripsInYear(int year, long minTrips) {
        List<Object[]> results = tripRepository.findScootersWithMoreThanXTripsInYear(year, minTrips);
        return results.stream()
                .map(result -> new ScooterTripsDTO((Long) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }

    public int calculateTotalBilled(int year, int startMonth, int endMonth) {
        // Get the start and end date of the range
        LocalDateTime startDate = LocalDateTime.of(year, startMonth, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(year, endMonth, 31, 23, 59);

        // Convert to Timestamps
        Timestamp startTimestamp = Timestamp.valueOf(startDate);
        Timestamp endTimestamp = Timestamp.valueOf(endDate);

        // Get trips within the date range
        List<Trip> trips = tripRepository.findByStartBetween(startTimestamp, endTimestamp);

        // Calculate total billed
        int total = 0;
        for (Trip trip : trips) {
            // Get the price associated with the trip
            Price price = priceRepository.findBySinceBefore(trip.getStart());
            total += price.getPrice() * trip.getDistance();
        }

        return total;
    }

}
