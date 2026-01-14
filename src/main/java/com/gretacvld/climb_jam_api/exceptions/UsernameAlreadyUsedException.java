package com.gretacvld.climb_jam_api.exceptions;

public class UsernameAlreadyUsedException extends RuntimeException {

    public UsernameAlreadyUsedException(String message) {
        super(message);
    }
}