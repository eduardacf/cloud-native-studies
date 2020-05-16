package com.dudacf26.cloudnative.tema6.exception;

public class DivisionByZeroException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DivisionByZeroException(String msg) {
        super(msg);
    }
}
