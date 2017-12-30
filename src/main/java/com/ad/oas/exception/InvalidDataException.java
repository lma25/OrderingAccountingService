package com.ad.oas.exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String msg) {
        super(msg);
    }
    public InvalidDataException(String msg, Throwable e) {
        super(msg, e);
    }
}
