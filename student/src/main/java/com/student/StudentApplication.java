package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StudentApplication {

    protected StudentApplication() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    public static void main(String... args) {
        SpringApplication.run(StudentApplication.class, args);
    }
}
