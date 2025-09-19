package com.marlon.parking.Dto.requests;

import com.marlon.parking.Entity.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleRequestDto {
    private String plate;
    private VehicleType type;
    private String color;
    private String documentId;
}
