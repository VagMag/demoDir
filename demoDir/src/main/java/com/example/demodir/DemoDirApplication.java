package com.example.demodir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.demodir")
@EntityScan("com.example.demodir")
public class DemoDirApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDirApplication.class, args);
    }

}
