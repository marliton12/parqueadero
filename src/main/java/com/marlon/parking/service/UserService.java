package com.marlon.parking.service;

import com.marlon.parking.Dto.requests.UserRequestDto;
import com.marlon.parking.Dto.responses.UserResponseDto;

import java.util.List;

public interface UserService {
    void createUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUsers();

    void deleteUser(String documentId);
}
