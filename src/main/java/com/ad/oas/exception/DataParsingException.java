package com.ad.oas.exception;

public class DataParsingException extends RuntimeException{
    public DataParsingException(String msg) {
        super(msg);
    }
    public DataParsingException(String msg, Throwable e) {
        super(msg, e);
    }
}
