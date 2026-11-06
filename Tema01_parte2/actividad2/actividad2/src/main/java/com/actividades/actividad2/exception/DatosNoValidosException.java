package com.actividades.actividad2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// 400: título/autor vacío, año <= 0...
public class DatosNoValidosException extends ResponseStatusException {
    public DatosNoValidosException(String mensaje) {
        super(HttpStatus.BAD_REQUEST, mensaje);
    }
}
