package com.actividades.actividad4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TablaController {

    private static final int MIN = 1;
    private static final int MAX = 20;
    private static final int POR_DEFECTO = 1;

    @GetMapping(value = "/tabla", produces = "text/html;charset=UTF-8")
    public String generarTabla(
            @RequestParam(name = "filas", defaultValue = "1") String filas,
            @RequestParam(name = "columnas", defaultValue = "1") String columnas) {

        int numFilas = normalizar(filas);
        int numColumnas = normalizar(columnas);

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

        // Encabezado con las columnas numeradas
        html.append("    <thead>\n      <tr>\n");
        for (int c = 1; c <= numColumnas; c++) {
            html.append("        <th>Columna ").append(c).append("</th>\n");
        }
        html.append("      </tr>\n    </thead>\n");

        // Cuerpo de la tabla: bucles anidados
        html.append("    <tbody>\n");
        for (int f = 1; f <= numFilas; f++) {
            html.append("      <tr>\n");
            for (int c = 1; c <= numColumnas; c++) {
                html.append("        <td>Fila ").append(f)
                    .append(", Columna ").append(c).append("</td>\n");
            }
            html.append("      </tr>\n");
        }
        html.append("    </tbody>\n");

        html.append("  </table>\n");
        html.append("</body>\n");
        html.append("</html>");

        return html.toString();
    }

    /**
     * Convierte el texto a entero y lo limita al rango [MIN, MAX].
     * - Parámetro ausente o vacío: llega como "1" gracias a defaultValue.
     * - No numérico: se usa el valor por defecto.
     * - Fuera de rango: se ajusta al mínimo o al máximo.
     */
    private int normalizar(String valor) {
        try {
            int numero = Integer.parseInt(valor.trim());
            return Math.max(MIN, Math.min(MAX, numero));
        } catch (NumberFormatException e) {
            return POR_DEFECTO;
        }
    }
}
