package com.kbt1.ollilove.userservice.exception;

public class BaseException extends RuntimeException{
    private int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }
}

