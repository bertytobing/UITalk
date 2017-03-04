package com.catapa.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@EnableEurekaServer
@PropertySource(value = "file:${CATAPA_CONFIG}/service-registry-application.properties")
@SpringBootApplication
public class ServiceRegistryApplication {

    protected ServiceRegistryApplication() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }
}
