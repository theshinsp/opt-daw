package com.actividades.actividad4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TablaController {
    // Pensé que al ser condiciones de validación tenía que ponerlo como constantes.
    static final Integer MIN = 1;
    static final Integer MAX = 20;
    static final Integer POR_DEFECTO = 1;

    @GetMapping("/tabla")
    public String generarTabla(@RequestParam(name = "filas", defaultValue = "1") String filas,
            @RequestParam(name = "columnas", defaultValue = "1") String columnas) {

        // paso ambos valores recibidos en los valores "noramlizados" o validados para el ejercicio.
        int numFilas = normalizar(filas);
        int numColumnas = normalizar(columnas);

        // Quería usar StringBuilder, el año pasado me parecía muchos más util que concatenar String.
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"es\">\n");
        html.append("<head>\n");
        html.append("  <meta charset=\"UTF-8\">\n");
        html.append("  <title>Tabla dinámica</title>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("  <h1>Tabla de ").append(numFilas).append(" x ")
            .append(numColumnas).append("</h1>\n");
        html.append("  <table border=\"1\">\n");

        // pongo las thead para identificar que es el encabezado de la tabla.
        html.append("    <thead>\n      <tr>\n");
        for (int i = 1; i <= numColumnas; i++) {
            html.append("        <th>Columna ").append(i).append("</th>\n"); // aquí enumero las columnas
        }
        html.append("      </tr>\n    </thead>\n");

        html.append("    <tbody>\n");
        // voy a hacer un bucle anidado como pide el ejercicio (creo) para crear las filas y celdas"
        for (int i = 1; i <= numFilas; i++) {
            html.append("      <tr>\n");
            for (int j = 1; j <= numColumnas; j++) {
                html.append("        <td>Fila ").append(i)
                    .append(", Columna ").append(j).append("</td>\n");
            }
            html.append("      </tr>\n");
        }
        html.append("    </tbody>\n");

        html.append("  </table>\n");
        html.append("</body>\n");
        html.append("</html>");

        return html.toString();
    }

    /** La parte de validación (no se si lo hice bien):
     * Convierte el texto a entero y lo limita al rango [MIN, MAX].
     * - Parámetro ausente o vacío: llega como "1" gracias a defaultValue.
     * - No numérico: se usa el valor por defecto.
     * - Fuera de rango: se ajusta al mínimo o al máximo.
     */
    private int normalizar(String valor) {
        try {
            int numero = Integer.parseInt(valor.trim()); // uso trim para quitar los espacios en blanco, por si acaso.
            return Math.max(MIN, Math.min(MAX, numero));
        } catch (NumberFormatException e) { // aquí uso el try catch para capturar la excepción que pide el ejercicio.
            return POR_DEFECTO;
        }
    }
}
