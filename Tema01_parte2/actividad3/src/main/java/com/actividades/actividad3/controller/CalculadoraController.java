package com.actividades.actividad3.controller;

import com.actividades.actividad3.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalculadoraController {

    @Autowired
    CalculadoraService calculadoraservice;

    @GetMapping("/calculadora/{operacion}/{numero1}/{numero2}")
    public ResponseEntity<Float> calcular(
            @PathVariable String operacion,
            @PathVariable Float numero1,
            @PathVariable Float numero2
    ) {
        return ResponseEntity.ok(calculadoraservice.calcular(operacion, numero1, numero2));
    }
}
