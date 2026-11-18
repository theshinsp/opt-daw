package com.actividades.actividad3.service;

import com.actividades.actividad3.exception.DivisionCeroException;
import com.actividades.actividad3.exception.NumeroFueraRangoException;
import com.actividades.actividad3.exception.NumeroNegativoException;
import com.actividades.actividad3.exception.OperacionInvalidaException;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    public Float calcular(String operacion, Float numero1, Float numero2) {
        Float resultado = 0.f;

        if (operacion.equalsIgnoreCase("division") && numero2 == 0) {
            throw new DivisionCeroException("No dividas entre 0 tontico.");
        }

        if (numero1 < 0 || numero2 < 0) {
            throw new NumeroNegativoException("No te me pongas negativo.");
        }

        if (numero1 > 100 || numero2 > 100) {
            throw new NumeroFueraRangoException("Números fuera de rango");
        }

        switch (operacion) {
            case "suma":
                resultado = numero1 + numero2;
                break;
            case "resta":
                resultado = numero1 - numero2;
                break;
            case "multiplicacion":
                resultado = numero1 * numero2;
                break;
            case "division":
                resultado = numero1 / numero2;
                break;
            default:
                throw new OperacionInvalidaException("Elige una operacion válida.");
        }
        return resultado;
    }
}
