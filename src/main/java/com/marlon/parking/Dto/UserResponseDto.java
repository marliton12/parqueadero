package com.marlon.parking.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {

    private Long id;

    private String name;

    private String documentId;

    private String phone;

    private String email;
}
