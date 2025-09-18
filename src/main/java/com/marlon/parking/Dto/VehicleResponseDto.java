package com.marlon.parking.Dto;

import com.marlon.parking.Entity.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VehicleResponseDto {

    private Long id;

    private String plate;

    private VehicleType type;

    private String color;
}
