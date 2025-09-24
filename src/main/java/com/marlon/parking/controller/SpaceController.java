package com.marlon.parking.controller;

import com.marlon.parking.Dto.responses.SpaceResponseDto;
import com.marlon.parking.service.SpaceService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/spaces")
public class SpaceController {

    private final SpaceService service;

    public SpaceController(SpaceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SpaceResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
