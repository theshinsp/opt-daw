package com.responsentity.actividad1.model;

public class Producto {
    Integer id;
    String texto;
    Double precio;

    public Producto() {
    }

    public Producto(Double precio, String texto, Integer id) {
        this.precio = precio;
        this.texto = texto;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
