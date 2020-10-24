package com.seagalputra.passport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PassportRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassportRegistryApplication.class, args);
    }
}
