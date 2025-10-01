package com.marlon.parking.controller;

import com.marlon.parking.Dto.responses.SpaceResponseDto;
import com.marlon.parking.service.SpaceService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(
            @PathVariable Long id
    ) {
        service.enable(id);
        return ResponseEntity.ok("Estado actualizado correctamente");
    }
}
