package com.ampliacion.reto1.controller;

import com.ampliacion.reto1.model.Obra;
import com.ampliacion.reto1.model.Reserva;
import com.ampliacion.reto1.model.Respuesta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaquillaController {

    // Cartelera inicial en memoria usando los datos sugeridos
    private final List<Obra> cartelera = new ArrayList<>(List.of(
            new Obra(101, "La Casa de Bernarda Alba", 25.0, 10),
            new Obra(102, "Yerma", 32.0, 5),
            new Obra(103, "El Tragaluz", 18.0, 20)
    ));

    // 2. Servir el formulario web de reserva
    @GetMapping("/reserva")
    public String formularioReserva() {
        return "reserva.html";
    }

    // 4. Buscador de obras con filtros opcionales (Caso C)
    @GetMapping("/cartelera")
    @ResponseBody
    public List<Obra> consultarCartelera(
            @RequestParam(name = "precioMax", required = false) Double precioMax,
            @RequestParam(name = "soloDisponibles", required = false) Boolean soloDisponibles) {

        List<Obra> obrasFiltradas = new ArrayList<>();

        for (Obra obra : cartelera) {
            boolean cumplePrecio = (precioMax == null || obra.getPrecioBase() <= precioMax);
            boolean cumpleDisponibilidad = (soloDisponibles == null || !soloDisponibles || obra.getAsientosLibres() > 0);

            if (cumplePrecio && cumpleDisponibilidad) {
                obrasFiltradas.add(obra);
            }
        }
        return obrasFiltradas;
    }

    // 3. Procesador de compras (Caso A y Caso B)
    @PostMapping("/reserva")
    @ResponseBody
    public Respuesta validarReserva(@ModelAttribute Reserva reserva) {
        Respuesta respuesta = new Respuesta();
        Obra obraEncontrada = null;

        // Buscar la obra en la cartelera por su ID (eventoId)
        for (Obra obra : cartelera) {
            if (obra.getId() == reserva.getEventoId()) {
                obraEncontrada = obra;
                break;
            }
        }

        // Si la obra no existe
        if (obraEncontrada == null) {
            respuesta.setEstado("RECHAZADA");
            respuesta.setMotivo("La obra seleccionada no existe.");
            return respuesta;
        }

        // --- COMPROBACIÓN 1: Verificación de aforo ---
        if (reserva.getCantidad() > obraEncontrada.getAsientosLibres()) {
            respuesta.setEstado("RECHAZADA");
            respuesta.setMotivo("Aforo insuficiente. Asientos disponibles restantes: " + obraEncontrada.getAsientosLibres());
            return respuesta;
        }

        // Si hay asientos suficientes, se restan del total disponible inmediatamente
        obraEncontrada.setAsientosLibres(obraEncontrada.getAsientosLibres() - reserva.getCantidad());

        // --- COMPROBACIÓN 2: Precio por entrada ---
        double precioUnitario = obraEncontrada.getPrecioBase();
        if ("VIP".equalsIgnoreCase(reserva.getTipoEntrada())) {
            precioUnitario = precioUnitario * 1.20; // 20% de recargo
        }

        double subtotal = precioUnitario * reserva.getCantidad();

        // --- COMPROBACIÓN 3: Descuentos acumulados ---
        double importeActual = subtotal;

        // Descuento por Volumen (4 o más entradas -> 10%)
        if (reserva.getCantidad() >= 4) {
            importeActual = importeActual * 0.90;
        }

        // Descuento por Cupón (15% adicional sobre el importe anterior)
        if ("DESCUENTO15".equals(reserva.getCodigoCupon())) {
            importeActual = importeActual * 0.85;
        }

        double totalAPagar = importeActual;
        double descuentoTotal = subtotal - totalAPagar;

        // Construir respuesta exitosa (Caso A)
        respuesta.setEstado("CONFIRMADA");
        respuesta.setCliente(reserva.getNombreCliente());
        respuesta.setEntradas(reserva.getCantidad());
        respuesta.setPrecioUnitario(precioUnitario);
        respuesta.setSubtotal(subtotal);
        respuesta.setDescuentoTotal(Math.round(descuentoTotal * 100.0) / 100.0); // Redondeo a 2 decimales
        respuesta.setTotalAPagar(Math.round(totalAPagar * 100.0) / 100.0);

        return respuesta;
    }
}
