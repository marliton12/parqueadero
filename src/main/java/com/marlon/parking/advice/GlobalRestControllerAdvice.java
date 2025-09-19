package com.marlon.parking.advice;

import com.marlon.parking.Exception.TariffNotFoundException;
import com.marlon.parking.Exception.UserDoesNotRegisteredException;
import com.marlon.parking.Exception.UserAlreadyRegisteredException;
import com.marlon.parking.Exception.VehicleNotFoundException;
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

    @ExceptionHandler(VehicleNotFoundException.class)
    public  String vehicleNotFoundException(VehicleNotFoundException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(TariffNotFoundException.class)
    public  String tariffNotFoundException(TariffNotFoundException exception){
        return exception.getMessage();
    }

}
