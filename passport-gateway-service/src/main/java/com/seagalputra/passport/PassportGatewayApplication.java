package com.seagalputra.passport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class PassportGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassportGatewayApplication.class, args);
    }
}
