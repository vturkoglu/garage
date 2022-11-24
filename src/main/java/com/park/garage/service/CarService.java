package com.park.garage.service;

import com.park.garage.configuration.GarageConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarService extends Vehicle {

    private final GarageConfiguration garageConfiguration;

    @Override
    public String park(String vehicle) {
        if (garageConfiguration.getParkedSlotSize() + VehicleType.Car.getSlot() > MAX_SLOT_SIZE) {
            throw new RuntimeException("Garage is full!");
        }
        garageConfiguration.garageSlots().put(vehicle, VehicleType.Car.getSlot());
        garageConfiguration.parkedSlotSize += VehicleType.Car.getSlot();
        return "Allocated " + VehicleType.Car.getSlot() + " slot";
    }

    @Override
    public String leave(String vehicle) {
        garageConfiguration.garageSlots().remove(vehicle);
        garageConfiguration.parkedSlotSize -= VehicleType.Car.getSlot();
        return "Deallocated " + VehicleType.Car.getSlot() + " slot";
    }
}
