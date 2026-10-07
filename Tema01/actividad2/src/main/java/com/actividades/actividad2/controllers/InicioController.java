package com.actividades.actividad2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Había hecho dos clases, pero los he juntado, por eso la clase se llama InicioController
public class InicioController {
    @GetMapping("/inicio")
    public String inicio() {
        return "<h1>Bienvenido a la aplicación</h1> <br>" +
                "<p>Texto de ejemplo Texto de ejemplo Texto de ejemplo Texto de ejemplo Texto de ejemplo Texto de ejemplo</p>";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "<h1>Página de contacto</h1> <br>" +
                "<p>email: manquepierdabetis@vivaelbeti.es<br>" +
                "tlf: +34 676-767-676</p>";
    }
}
