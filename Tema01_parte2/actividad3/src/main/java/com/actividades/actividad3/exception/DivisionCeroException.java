package com.actividades.actividad3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DivisionCeroException extends ResponseStatusException {
    public DivisionCeroException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
