package org.arquitecturas.grupo17.microservicetrip;

import org.arquitecturas.grupo17.microservicetrip.model.Pause;
import org.arquitecturas.grupo17.microservicetrip.model.Price;
import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.arquitecturas.grupo17.microservicetrip.repository.PauseRepository;
import org.arquitecturas.grupo17.microservicetrip.repository.PriceRepository;
import org.arquitecturas.grupo17.microservicetrip.repository.TripRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.sql.Timestamp;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceTripApplication implements CommandLineRunner {

    private final PauseRepository pauseRepository;
    private final PriceRepository priceRepository;
    private final TripRepository tripRepository;

    public MicroserviceTripApplication(PauseRepository pauseRepository, PriceRepository priceRepository, TripRepository tripRepository) {
        this.pauseRepository = pauseRepository;
        this.priceRepository = priceRepository;
        this.tripRepository = tripRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceTripApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.priceRepository.save(new Price(new Timestamp(124, 2, 11, 14, 0, 0, 0), 100, 200));
        this.priceRepository.save(new Price(new Timestamp(124, 6, 11, 14, 0, 0, 0), 100, 200));
        this.priceRepository.save(new Price(new Timestamp(124, 10, 11, 14, 0, 0, 0), 100, 200));

        Trip trip = new Trip(1, 1, 200, new Timestamp(124, 10, 11, 14, 0, 0, 0), new Timestamp(124, 10, 11, 15, 0, 0, 0));
        Pause pause = new Pause(new Timestamp(124, 10, 11, 14, 10, 0, 0), new Timestamp(124, 10, 11, 14, 30, 0, 0));
        trip.setPause(pause);

        this.tripRepository.save(trip);
        this.tripRepository.save(new Trip(1, 2, 300, new Timestamp(124, 10, 11, 14, 0, 0, 0), new Timestamp(124, 10, 11, 16, 0, 0, 0)));
        this.tripRepository.save(new Trip(1, 3, 150, new Timestamp(124, 8, 11, 14, 0, 0, 0), new Timestamp(124, 8, 11, 14, 30, 0, 0)));
        this.tripRepository.save(new Trip(1, 3, 150, new Timestamp(124, 8, 11, 18, 0, 0, 0), new Timestamp(124, 8, 11, 18, 30, 0, 0)));

    }
}
