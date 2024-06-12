package com.xxx.exception;

public class RegisterException extends Exception {
    public RegisterException(String message) {
        super(message + "\n");
    }
}
