package com.marlon.parking.controller;


import com.marlon.parking.Dto.UserRequestDto;
import com.marlon.parking.Dto.UserResponseDto;
import com.marlon.parking.Entity.User;
import com.marlon.parking.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto userRequestDto){
        userService.createUser(userRequestDto);
        return ResponseEntity
                .status(201)
                .body("registered");
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return ResponseEntity
                .ok(userService.getAllUsers());
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<String> deleteUser(@PathVariable String documentId){
        userService.deleteUser(documentId);
        return ResponseEntity
                .status(200)
                .body("user deleted");
    }
}
