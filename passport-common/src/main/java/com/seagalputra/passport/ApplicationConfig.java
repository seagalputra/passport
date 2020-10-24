package com.seagalputra.passport;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.seagalputra.passport")
public class ApplicationConfig {
}
