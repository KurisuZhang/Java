package com.xxx.exception;

public class UserListFullException extends Exception {

    public UserListFullException(String message) {
        super(message + "\n");
    }
}