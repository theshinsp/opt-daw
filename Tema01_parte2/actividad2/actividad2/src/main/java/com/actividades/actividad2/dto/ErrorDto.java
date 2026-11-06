package com.actividades.actividad2.dto;

public class ErrorDto {

    private final String mensaje;

    public ErrorDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
