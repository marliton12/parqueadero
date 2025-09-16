package com.marlon.parking.Exception;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String documentId)
    {
        super(String.format("user with document id %s already exist", documentId));
    }
}
