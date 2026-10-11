package com.actividades.actividad5.model;

import java.util.List;

public class Pedido {
    // Primero voy a crear la clase Pedido, luego crearé las clases de Cliente y Producto
    Cliente cliente ;
    List<Producto> productos;

    public Pedido() {
    }

    public Pedido(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
