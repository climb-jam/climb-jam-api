package com.gretacvld.climb_jam_api.exceptions;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String message) {
        super(message);
    }
}