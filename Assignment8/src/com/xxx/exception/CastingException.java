package com.xxx.exception;

public class CastingException extends Exception {

    public CastingException(String message) {
        super(message + "\n");
    }
}