package com.actividades.actividad6.controller;

import com.actividades.actividad6.model.Formulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class RegistroController {

    // Añadiré por aquí el Map.
    private final Map<String, String> usuarios = new HashMap<>();

    public RegistroController() {
        // Ejemplos de iniciación.
        usuarios.put("ana@example.com", "246810");
        usuarios.put("luis@example.com", "clave123");
    }

    @GetMapping("/registro")
    public String mostrarFormulario() {
        return "registro";
    } // está en templates/registro.html

    @PostMapping("/registro")
    @ResponseBody
    public String procesarRegistro(@ModelAttribute Formulario form) {
        // Debería haber puesto que devuelve una Respuesta, y crear una clase Respuesta. Siempre que se devuelva algo se hace en JSON
        // Voy a modificar como lo tenía hecho para declarar en variables para poder llamarlos más fácil.
        // Si un campo no llega (null) lo trato como cadena vacía, luego ya cumpliré las reglas de validación.
        String nombre = form.getNombre() == null ? "" : form.getNombre().trim();
        String apellidos = form.getApellidos() == null ? "" : form.getApellidos().trim();
        String correo = form.getCorreo() == null ? "" : form.getCorreo().trim();
        String pass = form.getPass() == null ? "" : form.getPass().trim();

        if (nombre.isEmpty() || correo.isEmpty()) {
            return "Tienes que introducir el nombre y el correo electrónico obligatoriamente";
        }

        boolean generada = pass.isEmpty();
        if (generada) {
            Random rand = new Random();
            int numero = rand.nextInt(1000000);   // entre 0 y 999999
            pass = String.format("%06d", numero); // siempre 6 dígitos (con ceros a la izquierda)
        }

        usuarios.put(correo, pass);

        String respuesta = "Usuario registrado: " + (nombre + " " + apellidos).trim()
                + "<br>Correo: " + correo;
        if (generada) {
            respuesta += "<br>Contraseña generada: " + pass;
        }
        return respuesta;
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";   // templates/login.html
    }

    @PostMapping("/login")
    @ResponseBody
    public String procesarLogin(@RequestParam(value = "usuario", defaultValue = "") String usuario,
                                @RequestParam(value = "pass", defaultValue = "") String pass) {
        // Decidí usar @RequestParam porque no quiero usar como objetos los valores que recojo.
        // Además que creo que el enunciado lo pide así.
        if (!usuarios.containsKey(usuario)) {
            return "Usuario inexistente";
        }
        if (!usuarios.get(usuario).equals(pass)) {
            return "Contraseña incorrecta";
        }
        return "Inicio de sesión correcto";
    }
}
