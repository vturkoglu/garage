package com.park.garage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VehicleFactory {

    private final CarService carService;
    private final JeepService jeepService;
    private final TruckService truckService;

    public Vehicle createVehicle(VehicleType vehicleType) {
        switch (vehicleType.getSlot()) {
            case 1:
                return carService;
            case 2:
                return jeepService;
            case 4:
                return truckService;
            default:
                throw new IllegalArgumentException("Unknown vehicle " + vehicleType);
        }
    }
}
