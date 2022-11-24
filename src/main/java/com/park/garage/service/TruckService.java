package com.park.garage.service;

import com.park.garage.configuration.GarageConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TruckService extends Vehicle {

    private final GarageConfiguration garageConfiguration;

    @Override
    public String park(String vehicle) {
        if (garageConfiguration.getParkedSlotSize() + VehicleType.Truck.getSlot() > MAX_SLOT_SIZE) {
            throw new RuntimeException("Garage is full!");
        }

        garageConfiguration.garageSlots().put(vehicle, VehicleType.Truck.getSlot());
        garageConfiguration.parkedSlotSize += VehicleType.Truck.getSlot();
        return "Allocated " + VehicleType.Truck.getSlot() + "slot";
    }

    @Override
    public String  leave(String vehicle) {
        garageConfiguration.garageSlots().remove(vehicle);
        garageConfiguration.parkedSlotSize -= VehicleType.Truck.getSlot();
        System.out.println("Deallocated 4 slots");
        return "Deallocated " + VehicleType.Truck.getSlot() + "slot";
    }
}
