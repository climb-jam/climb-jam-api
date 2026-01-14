package com.gretacvld.climb_jam_api.exceptions;

public class ProfileNotFoundException extends RuntimeException {

    public ProfileNotFoundException(String message) {
        super(message);
    }
}