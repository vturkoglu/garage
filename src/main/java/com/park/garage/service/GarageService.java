package com.park.garage.service;

import com.park.garage.configuration.GarageConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GarageService {

    private final VehicleFactory vehicleFactory;
    private final GarageConfiguration garageConfiguration;

    public String park(String vehicleProperties) throws Exception {
        if (garageConfiguration.garageSlots().containsKey(vehicleProperties)) {
            throw new Exception("This vehicle already exist!");
        }
        String vehicleType = vehicleProperties.substring(vehicleProperties.lastIndexOf(' ') + 1);
        Vehicle vehicle = vehicleFactory.createVehicle(VehicleType.valueOf(vehicleType));
        return vehicle.park(vehicleProperties);
    }

    public String leave(String vehicleProperties) throws Exception {
        if (!garageConfiguration.garageSlots().containsKey(vehicleProperties)) {
            throw new Exception("This vehicle is not in the Garage!");
        }
        String vehicleType = vehicleProperties.substring(vehicleProperties.lastIndexOf(' ') + 1);
        Vehicle vehicle = vehicleFactory.createVehicle(VehicleType.valueOf(vehicleType));
        return vehicle.leave(vehicleProperties);
    }
}
