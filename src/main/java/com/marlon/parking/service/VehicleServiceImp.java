package com.marlon.parking.service;

import com.marlon.parking.Dto.VehicleRequestDto;
import com.marlon.parking.Entity.Vehicle;
import com.marlon.parking.Repository.VehicleRepository;

public class VehicleServiceImp implements VehicleService{

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImp(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void createVehicle(VehicleRequestDto vehicleRequestDto) {
        Vehicle vehicle = new Vehicle(null, vehicleRequestDto.getPlate(), vehicleRequestDto.getType(), vehicleRequestDto.getColor(), null);
        vehicleRepository.save(vehicle);
    }
}
