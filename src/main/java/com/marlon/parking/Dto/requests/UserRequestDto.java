package com.marlon.parking.Dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDto {
    private String name;

    private String documentId;

    private String phone;

    private String email;
}
