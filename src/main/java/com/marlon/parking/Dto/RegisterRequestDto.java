package com.marlon.parking.Dto;

import com.marlon.parking.Entity.Vehicle;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class RegisterRequestDto {

    private String plate;

    private LocalDateTime entryHour;

    private LocalDateTime exitHour;

    private BigDecimal cost;

    public RegisterRequestDto(LocalDateTime entryHour, LocalDateTime exitHour, BigDecimal cost) {
        this.entryHour = entryHour;
        this.exitHour = exitHour;
        this.cost = cost;
    }

}
