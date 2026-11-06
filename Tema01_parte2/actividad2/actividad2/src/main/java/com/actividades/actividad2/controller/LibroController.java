package com.actividades.actividad2.controller;

import com.actividades.actividad2.dto.LibroCrearDto;
import com.actividades.actividad2.dto.LibroDto;
import com.actividades.actividad2.dto.LibroResumenDto;
import com.actividades.actividad2.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/libros") // Usaré RequestMapping para "simplificar" los endpoints
public class LibroController {

    // (Con @Autowired sobre el campo también valdría, como en los ejemplos del temario.)
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Lo que necesito: POST /libros -> 201 Created con el libro creado
    @PostMapping
    public ResponseEntity<LibroDto> crear(@RequestBody LibroCrearDto entrada) {
        LibroDto creado = libroService.crear(entrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // SGET /libros -> 200 OK con la lista reducida (id y titulo)
    @GetMapping
    public ResponseEntity<List<LibroResumenDto>> listar() {
        return ResponseEntity.ok(libroService.listar());
    }

    // GET /libros/{id} -> 200 OK con el libro (404 lo lanza el servicio si no existe)
    // @PathVariable lee el {id} de la URL.
    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> obtener(@PathVariable long id) {
        return ResponseEntity.ok(libroService.buscar(id));
    }

    // POST /libros/{id}/prestamo -> 200 OK con el libro ya prestado (404 / 409 los lanza el servicio)
    @PostMapping("/{id}/prestamo")
    public ResponseEntity<LibroDto> prestar(@PathVariable long id) {
        return ResponseEntity.ok(libroService.prestar(id));
    }

    // POST /libros/{id}/devolucion -> 200 OK con el libro ya devuelto (404 / 409 los lanza el servicio)
    @PostMapping("/{id}/devolucion")
    public ResponseEntity<LibroDto> devolver(@PathVariable long id) {
        return ResponseEntity.ok(libroService.devolver(id));
    }

    // en principio funciona correctamente, pero para algunas cosas he pedido ayuda al IA, sobretodo en el el Service y Exception.
    // aún no se por qué se estructura así pero supongo que es la manera eficiente de estructurarlo.
}
