package com.marlon.parking.controller;

import com.marlon.parking.Dto.requests.RegisterRequestDto;
import com.marlon.parking.Dto.requests.VehicleRequestDto;
import com.marlon.parking.Dto.responses.VehicleResponseDto;
import com.marlon.parking.service.RegisterService;
import com.marlon.parking.service.SpaceService;
import com.marlon.parking.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    private final RegisterService registerService;
    private final SpaceService spaceService;

    public VehicleController(VehicleService vehicleService, RegisterService registerService, SpaceService spaceService) {
        this.vehicleService = vehicleService;
        this.registerService = registerService;
        this.spaceService = spaceService;
    }

    @PostMapping
    public ResponseEntity<String> createVehicle(@RequestBody VehicleRequestDto vehicleRequestDto){
        vehicleService.createVehicle(vehicleRequestDto);
        registerService.insertRegister(new RegisterRequestDto(vehicleRequestDto.getPlate(), vehicleRequestDto.getIdSpace() , LocalDateTime.now(), LocalDateTime.now().plusHours(4)));
        spaceService.disable(vehicleRequestDto.getIdSpace());
        return ResponseEntity .status(200).body("registered");
    }

    @GetMapping
    public ResponseEntity<List <VehicleResponseDto>> getAllVehicle(){
        return ResponseEntity
                .ok(vehicleService.getAllVehicles());
    }

    @DeleteMapping("/{plate}")
    public ResponseEntity<String> deleteVehicles(@PathVariable String plate){
        vehicleService.deleteVehicle(plate);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
