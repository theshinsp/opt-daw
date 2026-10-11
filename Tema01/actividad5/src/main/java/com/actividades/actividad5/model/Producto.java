package com.actividades.actividad5.model;

import java.math.BigDecimal;

public class Producto {
    // Datos de los productos que llegan del JSON
    String nombre;
    Integer cantidad;
    BigDecimal precioUnitario;

    public Producto() {
    }

    public Producto(String nombre, Integer cantidad, BigDecimal precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
