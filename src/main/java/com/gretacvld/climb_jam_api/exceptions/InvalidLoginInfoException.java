package com.gretacvld.climb_jam_api.exceptions;

public class InvalidLoginInfoException extends RuntimeException {

    public InvalidLoginInfoException(String message) {
        super(message);
    }
}