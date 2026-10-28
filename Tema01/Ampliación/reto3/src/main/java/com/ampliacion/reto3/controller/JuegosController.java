package com.ampliacion.reto3.controller;

import com.ampliacion.reto3.model.Respuesta;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/juegos")

public class JuegosController {
/*
    @GetMapping("/dados")
    public Respuesta juegoDados(@RequestParam(defaultValue = 2) Integer cantidad,
                                @RequestParam(defaultValue = 6) Integer caras) {
        String mensaje = "Resultado";
        int suma = 0;
        boolean dobles = true;
        int primero = 0;

        if (cantidad < 1 || cantidad > 10) {
            return new Respuesta("La cantidad debe estar entre 1 y 10");
        }
        if (caras != 4 && caras != 6 && caras != 8 && caras != 10 && caras != 12 && caras != 20) {
            return new Respuesta("Las caras deben ser 4, 6, 8, 10, 12 o 20");
        }
        for (int i = 0; i < cantidad; i++) {
            int resultado = (int) (Math.random() * caras) + 1;
            mensaje += " " + resultado;
            suma += resultado;
            if (i == 0) {
                primero = resultado;
            } else if (resultado != primero) {
                dobles = false;
            }
        }

        return new Respuesta(mensaje);
    }
    */

    @GetMapping("/moneda")
    public Respuesta juegoMoneda(@RequestParam Integer lanzamientos) {
        int caras = 0;
        int cruz = 0;
        int tirada;
        for (int i = 0; i < lanzamientos; i++) {
            tirada = Math.random() < 0.5 ? caras++ : cruz++;
        }
        return new Respuesta("Has hecho " + lanzamientos + "Te han salido " + caras + " caras y te han salido " + cruz + " cruces.");
    }
}
