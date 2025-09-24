package com.marlon.parking.Dto.requests;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RegisterRequestDto {

    private String plate;

    private Long idSpace;

    private LocalDateTime entryHour;

    private LocalDateTime exitHour;

    public RegisterRequestDto(String plate, Long idSpace, LocalDateTime entryHour, LocalDateTime exitHour) {
        this.plate = plate;
        this.idSpace = idSpace;
        this.entryHour = entryHour;
        this.exitHour = exitHour;
    }

}
