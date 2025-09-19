package com.marlon.parking.Exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String plate) {
        super(String.format("the vehicle with the plate '%s' was not found", plate));
    }
}
