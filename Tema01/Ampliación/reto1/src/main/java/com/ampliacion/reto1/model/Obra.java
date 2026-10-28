package com.ampliacion.reto1.model;

public class Obra {
    Integer id;
    String titulo;
    Double precio;
    Integer asiento;

    public Obra() {
    }

    public Obra(Integer id, String titulo, Double precio, Integer asiento) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.asiento = asiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getAsiento() {
        return asiento;
    }

    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }
}
