package com.marlon.parking.Dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class RegisterResponseDto {
    private Long id;
    private LocalDateTime entryHour;
    private LocalDateTime exitHour;
    private BigDecimal cost;
    private VehicleResponseDto vehicleResponseDto;
}
