package com.dudacf26.cloudnative.tema8.exception;

public class InvalidOperationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidOperationException(String msg) {
        super(msg);
    }
}
