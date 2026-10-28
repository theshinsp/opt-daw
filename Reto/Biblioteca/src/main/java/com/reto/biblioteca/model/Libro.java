package com.reto.biblioteca.model;

import com.reto.biblioteca.enums.Estado;

import java.time.LocalDate;

public class Libro {
    Estado estado;
    String socio;
    String libro;
    Integer diasTotales;
    Integer fechaDevolucion;
    String motivo;

    public Libro(Estado estado, String socio, String libro, Integer diasTotales, Integer fechaDevolucion) {
        this.estado = estado;
        this.socio = socio;
        this.libro = libro;
        this.diasTotales = diasTotales;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro(Estado estado, String motivo) {
        this.estado = estado;
        this.motivo = motivo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public Integer getDiasTotales() {
        return diasTotales;
    }

    public void setDiasTotales(Integer diasTotales) {
        this.diasTotales = diasTotales;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Integer fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
