package com.example.m2.configs;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfiguration {

    @Bean
    public MeterRegistry meterRegistry() {
        // Create and configure the MeterRegistry instance here
        return new PrometheusMeterRegistry();
    }
}