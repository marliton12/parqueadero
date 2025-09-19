package com.marlon.parking.service;

import com.marlon.parking.Dto.requests.VehicleRequestDto;
import com.marlon.parking.Dto.responses.VehicleResponseDto;

import java.util.List;

public interface VehicleService {
    void createVehicle(VehicleRequestDto vehicleRequestDto);

    List<VehicleResponseDto> getAllVehicles();

    VehicleResponseDto findVehicleByPlate(String plate);

    void deleteVehicle(String plate);

}
