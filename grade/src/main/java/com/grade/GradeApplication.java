package com.grade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = "com.grade.*")
@ImportAutoConfiguration(FeignAutoConfiguration.class)
@SpringBootApplication
public class GradeApplication {

    protected GradeApplication() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    public static void main(String... args) {
        SpringApplication.run(GradeApplication.class, args);
    }
}
