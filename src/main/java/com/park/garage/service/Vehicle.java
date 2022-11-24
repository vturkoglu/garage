package com.park.garage.service;

public abstract class Vehicle {

    public static final int MAX_SLOT_SIZE = 10;

    abstract String park(String vehicle);

    abstract String leave(String vehicle);

}
