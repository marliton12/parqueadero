package com.marlon.parking.Dto.requests;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RegisterRequestDto {

    private String plate;

    private LocalDateTime entryHour;

    private LocalDateTime exitHour;

    public RegisterRequestDto(String plate, LocalDateTime entryHour, LocalDateTime exitHour) {
        this.plate = plate;
        this.entryHour = entryHour;
        this.exitHour = exitHour;
    }

}
