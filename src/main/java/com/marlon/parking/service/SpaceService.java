package com.marlon.parking.service;

import com.marlon.parking.Dto.responses.SpaceResponseDto;
import com.marlon.parking.Dto.responses.VehicleResponseDto;
import com.marlon.parking.Entity.Space;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SpaceService {
    List<SpaceResponseDto> getAll();

    void disable(Long id);

    Space findById(Long id);
}
