package com.marlon.parking.controller;

import com.marlon.parking.Dto.VehicleRequestDto;
import com.marlon.parking.Dto.VehicleResponseDto;
import com.marlon.parking.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List <VehicleResponseDto>> getAllVehicle(){
        return ResponseEntity
                .ok(vehicleService.getAllVehicles());
    }
}
