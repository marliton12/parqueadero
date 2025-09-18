package com.marlon.parking.service;

import com.marlon.parking.Dto.VehicleRequestDto;
import com.marlon.parking.Dto.VehicleResponseDto;
import com.marlon.parking.Entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    void createVehicle(VehicleRequestDto vehicleRequestDto);

    List<VehicleResponseDto> getAllVehicles();
}
