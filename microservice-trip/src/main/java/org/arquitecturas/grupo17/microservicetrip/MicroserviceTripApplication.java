package org.arquitecturas.grupo17.microservicetrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceTripApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceTripApplication.class, args);
    }

}
