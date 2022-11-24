package com.park.garage.service;

import com.park.garage.configuration.GarageConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JeepService extends Vehicle {

    private final GarageConfiguration garageConfiguration;

    @Override
    public String park(String vehicle) {
        if (garageConfiguration.getParkedSlotSize() + VehicleType.Jeep.getSlot() > MAX_SLOT_SIZE) {
            throw new RuntimeException("Garage is full!");
        }
        garageConfiguration.garageSlots().put(vehicle, VehicleType.Jeep.getSlot());
        garageConfiguration.parkedSlotSize += VehicleType.Jeep.getSlot();
        return "Allocated " + VehicleType.Jeep.getSlot() + "slot";
    }

    @Override
    public String  leave(String vehicle) {
        garageConfiguration.garageSlots().remove(vehicle);
        garageConfiguration.parkedSlotSize -= VehicleType.Jeep.getSlot();
        return "Deallocated " + VehicleType.Jeep.getSlot() + "slot";
    }
}
