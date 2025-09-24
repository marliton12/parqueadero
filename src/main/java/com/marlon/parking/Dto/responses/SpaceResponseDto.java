package com.marlon.parking.Dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class SpaceResponseDto {
    private Long id;
    private String code;
    private String type;
    private Boolean available;
}
