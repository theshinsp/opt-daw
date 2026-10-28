package com.responsentity.actividad1.controller;

import com.responsentity.actividad1.model.Producto;
import com.responsentity.actividad1.model.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final List<Producto> listaProductos = new ArrayList<>();

    public ProductoController() {
        listaProductos.add(new Producto(899.99, "Laptop", 1));
        listaProductos.add(new Producto(45.50, "Teclado Mecánico", 2));
        listaProductos.add(new Producto(25.00, "Ratón Inalámbrico", 3));
        listaProductos.add(new Producto(25.00, "Ratón", 4));
        listaProductos.add(new Producto(180.00, "Monitor", 5));
        listaProductos.add(new Producto(60.00, "Auriculares", 6));
    }


    // 200 OK con la lista de Producto;
    // si la lista está vacía, 404 Not Found con una Respuesta («No hay productos»)
    @GetMapping
    public ResponseEntity<?> obtenerProductos() {
        if (listaProductos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Respuesta("No hay productos"));
        }
        return ResponseEntity.ok(listaProductos);
    }

    // 200 OK con el Producto cuyo id se pasa como parámetro de consulta,
    // o 404 Not Found con una Respuesta si no existe ningún producto con ese id
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarProductoPorId(@RequestParam int id) {
        Optional<Producto> resultado = Optional.empty();
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                resultado = Optional.of(producto);
                break;
            }
        }
        Producto encontrada = resultado.orElse(null);
        if (encontrada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Respuesta("No existe producto con ese id"));
        }
        return ResponseEntity.ok(encontrada);
    }

    // 200 OK con una Respuesta como «Hay 3 productos»,
    // o 204 No Content sin cuerpo si no hay ninguno
    @GetMapping("/resumen")
    public ResponseEntity<?> obtenerResumen() {
        if (listaProductos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        int total = listaProductos.size();
        return ResponseEntity.ok(new Respuesta("Hay " + total + " productos"));
    }

    // 201 Created con el Producto creado (nombre «Producto N», precio fijo, id siguiente al último); si ya hay 5 productos,
    // 409 Conflict con una Respuesta («El catálogo está lleno»)
    @PostMapping("/nuevo")
    public ResponseEntity<?> crearProductoNuevo() {
        if (listaProductos.size() >= 5) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Respuesta("El catálogo está lleno"));
        }

        // Obtener el ID siguiente al último (si la lista está vacía empieza en 1)
        int siguienteId = listaProductos.isEmpty() ? 1 : listaProductos.getLast().getId() + 1;

        // El nombre debe seguir el formato «Producto Nx» y precio fijo (ej. 50.0)
        Producto nuevoProducto = new Producto(50.0, "Producto " + siguienteId,siguienteId );
        listaProductos.add(nuevoProducto);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
}
