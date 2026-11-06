package com.actividades.actividad2.dto;

public class LibroResumenDto {

    private final long id;
    private final String titulo;

    public LibroResumenDto(long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public long getId() { return id; }
    public String getTitulo() { return titulo; }
}
