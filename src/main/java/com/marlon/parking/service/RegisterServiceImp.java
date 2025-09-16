package com.marlon.parking.service;

import com.marlon.parking.Dto.RegisterRequestDto;
import com.marlon.parking.Entity.Register;
import com.marlon.parking.Entity.User;
import com.marlon.parking.Repository.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceImp implements RegisterService{

    private final RegisterRepository registerRepository;

    public RegisterServiceImp(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public void insertRegister(RegisterRequestDto registerRequestDto) {

        Register register = new Register(null, null,  registerRequestDto.getEntryHour(), registerRequestDto.getExitHour(), null, null);
        registerRepository.save(register);
    }
}
