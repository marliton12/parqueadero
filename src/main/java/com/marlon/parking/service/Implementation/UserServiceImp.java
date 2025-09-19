package com.marlon.parking.service.Implementation;

import com.marlon.parking.Dto.requests.UserRequestDto;
import com.marlon.parking.Dto.responses.UserResponseDto;
import com.marlon.parking.Entity.User;
import com.marlon.parking.Exception.UserDoesNotRegisteredException;
import com.marlon.parking.Exception.UserAlreadyRegisteredException;
import com.marlon.parking.Repository.UserRepository;
import com.marlon.parking.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
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
    public List<UserResponseDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserResponseDto> dtos = new ArrayList<>();
        for (User user : users) {
            UserResponseDto aux = new UserResponseDto(user.getId(), user.getName(), user.getDocumentId(), user.getPhone(), user.getEmail());
            dtos.add(aux);
        }
        return dtos;
    }

    @Transactional
    @Override
    public void deleteUser(String documentId) {
        User user = userRepository.findUserByDocumentId(documentId)
                .orElseThrow(() -> new UserDoesNotRegisteredException(documentId));

        userRepository.deleteByDocumentId(documentId);
    }
}
