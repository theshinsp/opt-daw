package com.ampliacion.reto1.model;

public class Reserva {
    Integer eventoId;
    String nombreCliente;
    String tipoEntrada;
    Integer cantidad;
    String codigoCupon;

    public Reserva() {
    }

    public Reserva(String codigoCupon, Integer cantidad, String tipoEntrada, String nombreCliente, Integer eventoId) {
        this.codigoCupon = codigoCupon;
        this.cantidad = cantidad;
        this.tipoEntrada = tipoEntrada;
        this.nombreCliente = nombreCliente;
        this.eventoId = eventoId;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoCupon() {
        return codigoCupon;
    }

    public void setCodigoCupon(String codigoCupon) {
        this.codigoCupon = codigoCupon;
    }
}
