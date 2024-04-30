package com.w4t3rcs.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WebConfig {
    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }
}
