package com.dudacf26.cloudnative.tema2.exceptions;

public class ServiceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceNotFoundException(String message) {
        super(message);
    }
}


