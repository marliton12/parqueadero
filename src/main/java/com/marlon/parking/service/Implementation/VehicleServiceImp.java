package com.marlon.parking.service.Implementation;

import com.marlon.parking.Dto.requests.VehicleRequestDto;
import com.marlon.parking.Dto.responses.VehicleResponseDto;
import com.marlon.parking.Entity.User;
import com.marlon.parking.Entity.Vehicle;
import com.marlon.parking.Exception.UserDoesNotRegisteredException;
import com.marlon.parking.Exception.VehicleAlreadyRegisteredException;
import com.marlon.parking.Exception.VehicleNotFoundException;
import com.marlon.parking.Repository.UserRepository;
import com.marlon.parking.Repository.VehicleRepository;
import com.marlon.parking.service.VehicleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImp implements VehicleService {

    private final VehicleRepository vehicleRepository;

    private final UserRepository userRepository;

    public VehicleServiceImp(VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void createVehicle(VehicleRequestDto vehicleRequestDto) {
        Optional<Vehicle> vehicleExist = vehicleRepository.findByPlate(vehicleRequestDto.getPlate());
        if (vehicleExist.isEmpty()) {
            User user = userRepository.findUserByDocumentId(vehicleRequestDto.getDocumentId()).orElseThrow(() -> new UserDoesNotRegisteredException(vehicleRequestDto.getDocumentId()));
            Vehicle vehicle = new Vehicle(null, vehicleRequestDto.getPlate(), vehicleRequestDto.getType(), vehicleRequestDto.getColor(), user);
            vehicleRepository.save(vehicle);
        }else{
            throw new VehicleAlreadyRegisteredException(vehicleRequestDto.getPlate());
        }
    }

    @Override
    public List<VehicleResponseDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleResponseDto> dtos = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            VehicleResponseDto aux = new VehicleResponseDto(vehicle.getId(), vehicle.getPlate(), vehicle.getType(), vehicle.getColor(), null);
            dtos.add(aux);
        }
        return dtos;
    }

    @Override
    public VehicleResponseDto findVehicleByPlate(String plate) {
        Vehicle vehicle = vehicleRepository.findByPlate(plate).orElseThrow(() -> new VehicleNotFoundException(plate));
        VehicleResponseDto dto = new VehicleResponseDto(vehicle.getId(), vehicle.getPlate(), vehicle.getType(), vehicle.getColor(), null);
        return dto;
    }

    @Transactional
    @Override
    public void deleteVehicle(String plate) {
        Vehicle vehicle = vehicleRepository.findByPlate(plate).orElseThrow(() -> new VehicleNotFoundException(plate));
        vehicleRepository.deleteByPlate(plate);
    }

}
