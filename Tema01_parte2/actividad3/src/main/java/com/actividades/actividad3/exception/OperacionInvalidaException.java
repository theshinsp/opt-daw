package com.actividades.actividad3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OperacionInvalidaException extends ResponseStatusException {
    public OperacionInvalidaException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
