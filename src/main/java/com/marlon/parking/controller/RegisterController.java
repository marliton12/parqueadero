package com.marlon.parking.controller;

import com.marlon.parking.Dto.requests.RegisterRequestDto;
import com.marlon.parking.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register/v1")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping
    public ResponseEntity<String> insertRegister(@RequestBody RegisterRequestDto registerRequestDto){
            registerService.insertRegister(registerRequestDto);
            return ResponseEntity
                    .status(201)
                    .body("added");
    }
}
