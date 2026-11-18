package com.solucion.actividad2Solution.controller;

import com.solucion.actividad2Solution.dto.LibroCrearDto;
import com.solucion.actividad2Solution.dto.LibroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @PostMapping
    public ResponseEntity<LibroDto> crear(@RequestBody LibroCrearDto entrada) {
        LibroDto creado = libroService.crear(entrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
