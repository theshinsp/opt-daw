package com.actividades.actividad6.controller;

import com.actividades.actividad6.model.Formulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Random;

@Controller
public class RegistroController {

    @GetMapping("/registro")
    public String mostrarFormulario() {
        return "registro";
    }

    @PostMapping("/registro")
    @ResponseBody
    public String procesarRegistro(@ModelAttribute Formulario form) {
        Random rand = new Random();
        String pass = form.getPass();
        if (form.getNombre().trim().isEmpty() || form.getCorreo().trim().isEmpty()) {
            return "Tienes que introducir el nombre y el correo electrónico obligatoriamente";
        }
        if (pass.trim().isEmpty()) {
            Integer numero = rand.nextInt(1000000); // Genera un número entre 0 y 999999
            pass = String.format("%06d", numero); // Asegura los 6 dígitos conservan
        }
        // Map login = new Map(form.getNombre(), pass);
        String respuesta = String.format("<h2>Formulario de prueba</h2> <br>Nombre: %s<br>Apellidos: %s<br>Correo electrónico: %s<br>Contraseña: %s ", form.getNombre(), form.getApellidos(), form.getCorreo(), pass);
        return respuesta;
    }
}
