package com.marlon.parking.service;

import com.marlon.parking.Dto.requests.RegisterRequestDto;
import com.marlon.parking.Dto.responses.RegisterResponseDto;

public interface RegisterService {
    void insertRegister(RegisterRequestDto registerRequestDto);
    RegisterResponseDto get(Long spaceId);
}
