package com.marlon.parking.service;

import com.marlon.parking.Dto.UserRequestDto;
import com.marlon.parking.Entity.User;

import java.util.List;

public interface UserService {
    void createUser(UserRequestDto userRequestDto);

    List<User> getAllUsers();

    void deleteUser(String documentId);
}
