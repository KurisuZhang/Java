package com.xxx.exception;

public class CRUDTaskException extends Exception {
    public CRUDTaskException(String message) {
        super(message + "\n");
    }
}
