package com.park.garage.controller;

import com.park.garage.configuration.GarageConfiguration;
import com.park.garage.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("garage")
public class GarageController {

    private final GarageService garageService;
    private final GarageConfiguration garageConfiguration;

    @PostMapping("/park/{vehicle}")
    ResponseEntity<String> park(@PathVariable String vehicle) throws Exception {
        return ResponseEntity.ok(garageService.park(vehicle));
    }

    @PostMapping("/leave/{vehicle}")
    ResponseEntity<String> leave(@PathVariable String vehicle) throws Exception {
        return ResponseEntity.ok(garageService.leave(vehicle));
    }

    @GetMapping("/status")
    ResponseEntity<Map<String, Integer>> status() {
        return ResponseEntity.ok(garageConfiguration.garageSlots());
    }
}
