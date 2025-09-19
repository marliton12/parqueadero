package com.marlon.parking.service;

import com.marlon.parking.Dto.requests.RegisterRequestDto;

public interface RegisterService {
    void insertRegister(RegisterRequestDto registerRequestDto);
}
