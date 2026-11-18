package com.actividades.actividad3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NumeroFueraRangoException extends ResponseStatusException {
    public NumeroFueraRangoException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
