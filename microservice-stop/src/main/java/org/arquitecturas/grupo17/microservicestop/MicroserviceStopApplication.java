package org.arquitecturas.grupo17.microservicestop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceStopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStopApplication.class, args);
    }

}
