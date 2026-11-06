package com.actividades.actividad2.exception;

import com.actividades.actividad2.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

// El enunciado pide que los errores salgan con el DTO de error: {"mensaje": "..."}. Pero u
// na ResponseStatusException "a pelo" daría el JSON por defecto de Spring (timestamp, status, error...),
// así que esta clase CAPTURA cualquier ResponseStatusException lanzada por el servicio y la convierte en: el código HTTP de la excepción + un ErrorDto como cuerpo.
// Y para que funcione parece que se necesita @RestControllerAdvice = "vigilante" de todos los controladores. Si no, esta estructura no funcionaría.
@RestControllerAdvice // esto es nuevo
public class ManejadorErrores {

    @ExceptionHandler(ResponseStatusException.class) // esto también es nuevo
    public ResponseEntity<ErrorDto> manejar(ResponseStatusException e) {
        return ResponseEntity
                .status(e.getStatusCode())          // 400 / 404 / 409 según la excepción
                .body(new ErrorDto(e.getReason())); // el mensaje que pusimos al lanzarla
    }
}
