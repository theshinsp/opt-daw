package com.ampliacion.reto1.model;

import com.ampliacion.reto1.enums.Estado;

public class Respuesta {
    Estado estado;
    String cliente;
    String motivo;
    Integer entradas;
    Double precioUnitario;
    Double descuentoTotal;
    Double totalAPagar;

    public Respuesta() {
    }

    public Respuesta(String motivo, Estado estado) {
        this.motivo = motivo;
        this.estado = estado;
    }

    public Respuesta(Estado estado, String cliente, Integer entradas, Double precioUnitario, Double descuentoTotal, Double totalAPagar) {
        this.estado = estado;
        this.cliente = cliente;
        this.entradas = entradas;
        this.precioUnitario = precioUnitario;
        this.descuentoTotal = descuentoTotal;
        this.totalAPagar = totalAPagar;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getEntradas() {
        return entradas;
    }

    public void setEntradas(Integer entradas) {
        this.entradas = entradas;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(Double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
