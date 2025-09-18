package com.marlon.parking.service;

import com.marlon.parking.Dto.UserResponseDto;
import com.marlon.parking.Dto.VehicleRequestDto;
import com.marlon.parking.Dto.VehicleResponseDto;
import com.marlon.parking.Entity.User;
import com.marlon.parking.Entity.Vehicle;
import com.marlon.parking.Repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public List<VehicleResponseDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleResponseDto> dtos = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            VehicleResponseDto aux = new VehicleResponseDto(vehicle.getId(), vehicle.getPlate(), vehicle.getType(), vehicle.getColor());
            dtos.add(aux);
        }
        return dtos;
    }
}
