package com.marlon.parking.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RegisterRequestDto {
    private LocalDateTime entryHour;

    private LocalDateTime exitHour;

    private BigDecimal cost;

    public RegisterRequestDto(LocalDateTime entryHour, LocalDateTime exitHour, BigDecimal cost) {
        this.entryHour = entryHour;
        this.exitHour = exitHour;
        this.cost = cost;
    }

    public LocalDateTime getEntryHour() {
        return entryHour;
    }

    public LocalDateTime getExitHour() {
        return exitHour;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
