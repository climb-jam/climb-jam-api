package com.gretacvld.climb_jam_api.exceptions;

public class SessionNotFoundException extends RuntimeException {

    public SessionNotFoundException(String message) {
        super(message);
    }
}