package org.arquitecturas.grupo17.congifservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CongifServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CongifServiceApplication.class, args);
    }

}
