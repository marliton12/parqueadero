package com.marlon.parking.advice;

import com.marlon.parking.Exception.UserDoesNotRegisteredException;
import com.marlon.parking.Exception.UserAlreadyRegisteredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public String userAlreadyRegisteredException(UserAlreadyRegisteredException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(UserDoesNotRegisteredException.class)
    public  String userAlreadyDeleteException(UserDoesNotRegisteredException exception){
        return exception.getMessage();
    }

}
