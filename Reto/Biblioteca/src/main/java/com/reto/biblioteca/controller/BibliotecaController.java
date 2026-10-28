package com.reto.biblioteca.controller;

import com.reto.biblioteca.model.Libro;
import com.reto.biblioteca.model.Respuesta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BibliotecaController {
    final Integer DIAS_EXTRA_PREMIUN = 7;

    private final List<Libro> catalogo = List.of(
            new Libro(1, "Don Quijote de la Mancha", "Miguel de Cervantes", "novela", 3),
            new Libro(2, "Cien años de soledad", "Gabriel García Márquez", "novela", 0),
            new Libro(3, "La sombra del viento", "Carlos Ruiz Zafón", "novela", 2),
            new Libro(4, "Breve historia del tiempo", "Stephen Hawking", "ciencia", 1),
            new Libro(5, "Cosmos", "Carl Sagan", "ciencia", 4),
            new Libro(6, "Sapiens", "Yuval Noah Harari", "historia", 0));
@GetMapping("/prestamo")
    public class prestamo(){
return "prestamo";
}

}
