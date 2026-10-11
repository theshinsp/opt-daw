package com.actividades.actividad5.model;

import java.math.BigDecimal;

public class RespuestaPedido {
    // Es la clase que usaría para devolver el JSON
    String cliente;
    Integer totalProductos;
    BigDecimal precioTotal;
    String mensaje;

    public RespuestaPedido(String cliente, Integer totalProductos, BigDecimal precioTotal, String mensaje) {
        this.cliente = cliente;
        this.totalProductos = totalProductos;
        this.precioTotal = precioTotal;
        this.mensaje = mensaje;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(Integer totalProductos) {
        this.totalProductos = totalProductos;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
