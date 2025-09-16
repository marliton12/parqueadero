package com.marlon.parking.controller;

import com.marlon.parking.Dto.VehicleRequestDto;
import com.marlon.parking.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<String> createVehicle(@RequestBody VehicleRequestDto vehicleRequestDto){
        vehicleService.createVehicle(vehicleRequestDto);
        return ResponseEntity .status(200).body("registered");
    }
}
