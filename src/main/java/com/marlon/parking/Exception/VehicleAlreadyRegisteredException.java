package com.marlon.parking.Exception;

public class VehicleAlreadyRegisteredException extends RuntimeException {
    public VehicleAlreadyRegisteredException(String plate) {
        super (String.format("This vehicle with plate '%s' already exist", plate));
    }
}
