package com.actividades.actividad5.controller;

import com.actividades.actividad5.model.Pedido;
import com.actividades.actividad5.model.Producto;
import com.actividades.actividad5.model.RespuestaPedido;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PedidoController {

    @PostMapping("/pedido")
    // Para devolver una respuesta también me haría falta una clase donde devuelva un json de respuesta.
    public RespuestaPedido procesarPedido(@RequestBody Pedido pedido) {

        BigDecimal total = BigDecimal.ZERO; // No sabía qué me fallaba, pero tenía que poner BigDecimal.ZERO.
        Integer totalProductos = 0;

        for (Producto p : pedido.getProductos()) {
            //  Obtengo datos de los productos.
            // total += p.getPrecioUnitario() * p.getCantidad(); Me daba error esto todo el rato.
            // El precio total de cada línea de producto

            // Tuve que buscar información: https://codegym.cc/es/groups/posts/es.216.bigdecimal-en-java
            // Y buscar métodos: https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html#method.summary
            BigDecimal subtotal = p.getPrecioUnitario().multiply(new BigDecimal(p.getCantidad()));
            total = total.add(subtotal);

            // Sumo la cantidad de cuántos productos hay.
            totalProductos += p.getCantidad();
        }

        //Voy a incializar por constructor, me parece más rápido y fácil.
        return new RespuestaPedido(
                pedido.getCliente().getNombre(),
                totalProductos,
                total,
                "Pedido recibido correctamente");

        /* Esta sería la manera "normal" para generar la respuesta. Pero me gusta más hacerlo como arriba.
        RespuestaPedido respuesta = new RespuestaPedido();
        respuesta.setCliente(pedido.getCliente().getNombre());
        respuesta.setTotalProductos(totalProductos);
        respuesta.setPrecioTotal(total);
        respuesta.setMensaje("Pedido recibido correctamente");

        return respuesta;
        */
    }
}
