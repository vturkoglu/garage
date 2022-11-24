package com.park.garage.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class GarageConfiguration {

    public Integer parkedSlotSize = 0;

    @Bean
    public Map<String, Integer> garageSlots() {
        return new HashMap<>();
    }

    @Bean
    public Integer getParkedSlotSize() {
        return this.parkedSlotSize;
    }
}
