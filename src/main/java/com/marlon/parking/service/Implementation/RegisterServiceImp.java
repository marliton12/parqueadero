package com.marlon.parking.service.Implementation;

import com.marlon.parking.Dto.requests.RegisterRequestDto;
import com.marlon.parking.Dto.responses.RegisterResponseDto;
import com.marlon.parking.Dto.responses.UserResponseDto;
import com.marlon.parking.Dto.responses.VehicleResponseDto;
import com.marlon.parking.Entity.*;
import com.marlon.parking.Exception.TariffNotFoundException;
import com.marlon.parking.Exception.VehicleNotFoundException;
import com.marlon.parking.Repository.RegisterRepository;
import com.marlon.parking.Repository.SpaceRepository;
import com.marlon.parking.Repository.TariffRepository;
import com.marlon.parking.Repository.VehicleRepository;
import com.marlon.parking.service.RegisterService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RegisterServiceImp implements RegisterService {

    private final RegisterRepository registerRepository;
    private final VehicleRepository vehicleRepository;
    private final TariffRepository tariffRepository;
    private final SpaceRepository spaceRepository;

    public RegisterServiceImp(RegisterRepository registerRepository, VehicleRepository vehicleRepository, TariffRepository tariffRepository, SpaceRepository spaceRepository) {
        this.registerRepository = registerRepository;
        this.vehicleRepository = vehicleRepository;
        this.tariffRepository = tariffRepository;
        this.spaceRepository = spaceRepository;
    }

    @Transactional
    @Override
    public void insertRegister(RegisterRequestDto registerRequestDto) {

        Vehicle vehicle = vehicleRepository.findByPlate(registerRequestDto.getPlate())
                .orElseThrow(() -> new VehicleNotFoundException(registerRequestDto.getPlate()));

        // Buscar tarifa según el tipo de vehículo
        Tariff tariff = tariffRepository.findByType(vehicle.getType())
                .orElseThrow(TariffNotFoundException::new);

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
        register.setSpace(spaceRepository.findById(registerRequestDto.getIdSpace()).get());
        register.setEntryHour(registerRequestDto.getEntryHour());
        register.setExitHour(registerRequestDto.getExitHour());
        register.setCost(cost);

        registerRepository.save(register);
    }

    @Override
    public RegisterResponseDto get(Long spaceId) {
        Register register = registerRepository.findBySpace_Id(spaceId).get();
        Vehicle vehicle = register.getVehicle();
        User user = register.getVehicle().getUser();
        return new RegisterResponseDto(register.getId(), register.getEntryHour(), register.getExitHour(), register.getCost(), new VehicleResponseDto(vehicle.getId(), vehicle.getPlate(), vehicle.getType(), vehicle.getColor(), new UserResponseDto(user.getId(), user.getName(), user.getDocumentId(), user.getPhone(), user.getEmail())));
    }
}
