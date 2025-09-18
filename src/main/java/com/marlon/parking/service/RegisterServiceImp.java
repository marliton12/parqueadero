package com.marlon.parking.service;

import com.marlon.parking.Dto.RegisterRequestDto;
import com.marlon.parking.Dto.VehicleRequestDto;
import com.marlon.parking.Entity.Register;
import com.marlon.parking.Entity.Tariff;
import com.marlon.parking.Entity.User;
import com.marlon.parking.Entity.Vehicle;
import com.marlon.parking.Repository.RegisterRepository;
import com.marlon.parking.Repository.TariffRepository;
import com.marlon.parking.Repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class RegisterServiceImp implements RegisterService{

    private final RegisterRepository registerRepository;
    private final VehicleRepository vehicleRepository;
    private final TariffRepository tariffRepository;

    public RegisterServiceImp(RegisterRepository registerRepository, VehicleRepository vehicleRepository, TariffRepository tariffRepository) {
        this.registerRepository = registerRepository;
        this.vehicleRepository = vehicleRepository;
        this.tariffRepository = tariffRepository;
    }

    @Override
    public void insertRegister(RegisterRequestDto registerRequestDto) {

        Vehicle vehicle = vehicleRepository.findByPlate(registerRequestDto.getPlate())
                .orElseThrow(() -> new RuntimeException("Vehícle with plate " + registerRequestDto.getPlate() + "not found."));

        // Buscar tarifa según el tipo de vehículo
        Tariff tariff = tariffRepository.findByType(vehicle.getType())
                .orElseThrow(() -> new RuntimeException("Tarifa no encontrada para tipo: " + vehicle.getType()));

        // Calcular horas
        long hours = java.time.Duration.between(registerRequestDto.getEntryHour(), registerRequestDto.getExitHour()).toHours();
        if (hours == 0) {
            hours = 1; // mínimo una hora
        }

        // Calcular costo
        BigDecimal cost = BigDecimal.valueOf(tariff.getTimeValue())
                .multiply(BigDecimal.valueOf(hours));

        // Crear y guardar el registro
        Register register = new Register();
        register.setVehicle(vehicle);
        register.setEntryHour(registerRequestDto.getEntryHour());
        register.setExitHour(registerRequestDto.getExitHour());
        register.setCost(cost);

        registerRepository.save(register);
    }
}
