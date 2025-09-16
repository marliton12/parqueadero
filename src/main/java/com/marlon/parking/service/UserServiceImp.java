package com.marlon.parking.service;

import com.marlon.parking.Dto.UserRequestDto;
import com.marlon.parking.Entity.User;
import com.marlon.parking.Exception.UserDoesNotRegisteredException;
import com.marlon.parking.Exception.UserAlreadyRegisteredException;
import com.marlon.parking.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserRequestDto userRequestDto) {
       Optional<User> userOptional = userRepository.findUserByDocumentId(userRequestDto.getDocumentId());
        if (userOptional.isPresent()){
            throw new UserAlreadyRegisteredException(userRequestDto.getDocumentId());
        }

        User user = new User(null, userRequestDto.getName(), userRequestDto.getDocumentId(),userRequestDto.getPhone(),userRequestDto.getEmail());
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String documentId) {
        User user = userRepository.findUserByDocumentId(documentId)
                .orElseThrow(() -> new UserDoesNotRegisteredException(documentId));

        userRepository.deleteByDocumentId(documentId);
    }
}
