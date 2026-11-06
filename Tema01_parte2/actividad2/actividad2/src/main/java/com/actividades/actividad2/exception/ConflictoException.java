package com.actividades.actividad2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// 409: ISBN duplicado, prestar un libro ya prestado, devolver uno que no está prestado.
public class ConflictoException extends ResponseStatusException {
    public ConflictoException(String mensaje) {
        super(HttpStatus.CONFLICT, mensaje);
    }
}
