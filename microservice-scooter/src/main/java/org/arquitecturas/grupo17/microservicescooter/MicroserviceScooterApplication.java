package org.arquitecturas.grupo17.microservicescooter;

import org.arquitecturas.grupo17.microservicescooter.model.Scooter;
import org.arquitecturas.grupo17.microservicescooter.repository.ScooterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceScooterApplication implements CommandLineRunner {

    private final ScooterRepository scooterRepository;

    public MicroserviceScooterApplication(ScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceScooterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.scooterRepository.save(new Scooter(0, 15, 10));
        this.scooterRepository.save(new Scooter(0, 64, 7));
        this.scooterRepository.save(new Scooter(2, 16, 98));
        this.scooterRepository.save(new Scooter(1, 0, 0));
    }
}
