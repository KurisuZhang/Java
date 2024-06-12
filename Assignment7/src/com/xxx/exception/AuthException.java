package com.xxx.exception;

public class AuthException extends Exception {

    public AuthException(String message) {
        super(message + "\n");
    }
}