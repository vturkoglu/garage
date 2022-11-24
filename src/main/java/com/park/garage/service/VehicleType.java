package com.park.garage.service;

import lombok.Getter;

public enum VehicleType {

    Car(1),
    Jeep(2),
    Truck(4);

    @Getter
    private final int slot;

    VehicleType(int slot) {
        this.slot = slot;
    }

}
