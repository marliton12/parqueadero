package com.marlon.parking.controller;

import com.marlon.parking.Dto.requests.RegisterRequestDto;
import com.marlon.parking.Dto.responses.RegisterResponseDto;
import com.marlon.parking.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/{spaceId}")
    public ResponseEntity<RegisterResponseDto> get(@PathVariable Long spaceId){
        RegisterResponseDto registerResponseDto = registerService.get(spaceId);
        return ResponseEntity.ok(registerResponseDto);
    }

}
