package com.marlon.parking.Exception;

public class UserDoesNotRegisteredException extends RuntimeException {
    public UserDoesNotRegisteredException(String documentId) {

        super(String.format("user with document id %s don't exist", documentId));
    }
}
