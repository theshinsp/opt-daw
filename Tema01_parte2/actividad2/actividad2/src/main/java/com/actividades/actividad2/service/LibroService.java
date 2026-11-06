package com.actividades.actividad2.service;

import com.actividades.actividad2.dto.LibroCrearDto;
import com.actividades.actividad2.dto.LibroDto;
import com.actividades.actividad2.dto.LibroResumenDto;
import com.actividades.actividad2.exception.ConflictoException;
import com.actividades.actividad2.exception.DatosNoValidosException;
import com.actividades.actividad2.exception.RecursoNoEncontradoException;
import com.actividades.actividad2.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
He intentado hacerlo solo pero aún no lo tengo muy claro, y he pedido ayuda al IA para que me vaya guiando.
A parte de intentar buscar fuentes: https://www.geeksforgeeks.org/advance-java/spring-boot-service-annotation-with-example/

Anotación final: En principio está bien y funciona pero realmente tengo que comprobarlo otra vez ya que lo hice muy guiado.
Además de que me ha guiado para hacer un directorio de excepciones y cómo se maneja las excepciones.
No se si está bien pero en principio funciona bien, y creo que lo entiendo (?)
 */
// SERVICIO = el "cerebro": aquí viven las reglas de negocio y la conversión DTO <-> modelo.
// NO sabe nada de HTTP (rutas, ResponseEntity...). Solo lanza excepciones cuando algo falla.
// @Service -> Spring lo registra como bean y se lo entrega al controlador (inyección de dependencias).
@Service
public class LibroService {

    // Los libros se guardan EN MEMORIA (se pierden al parar la app).
    // LinkedHashMap: busca por id rápido y mantiene el orden de inserción para el listado.
    private final Map<Long, Libro> libros = new LinkedHashMap<>();
    private long siguienteId = 1;   // ids numéricos, incrementales, empezando en 1

    public LibroDto crear(LibroCrearDto entrada) {
        // 400: datos no válidos (título/autor vacío, año <= 0)
        if (entrada.getTitulo() == null || entrada.getTitulo().isBlank()) {
            throw new DatosNoValidosException("El título no puede estar vacío");
        }
        if (entrada.getAutor() == null || entrada.getAutor().isBlank()) {
            throw new DatosNoValidosException("El autor no puede estar vacío");
        }
        if (entrada.getAnioPublicacion() <= 0) {
            throw new DatosNoValidosException("El año de publicación debe ser mayor que 0");
        }
        // (el ISBN también es obligatorio para poder comprobar duplicados)
        if (entrada.getIsbn() == null || entrada.getIsbn().isBlank()) {
            throw new DatosNoValidosException("El ISBN no puede estar vacío");
        }

        // 409: no puede haber dos libros con el mismo ISBN
        for (Libro existente : libros.values()) {
            if (existente.getIsbn().equals(entrada.getIsbn())) {
                throw new ConflictoException("Ya existe un libro con el ISBN " + entrada.getIsbn());
            }
        }

        // El servidor decide el id; el estado de préstamo y las notas los pone el modelo
        Libro libro = new Libro(siguienteId, entrada.getTitulo(), entrada.getAutor(),
                entrada.getIsbn(), entrada.getAnioPublicacion());
        libros.put(siguienteId, libro);
        siguienteId++;

        return aDto(libro);   // modelo -> DTO de salida
    }

    // ---------- Listar libros (versión reducida) ----------
    public List<LibroResumenDto> listar() {
        List<LibroResumenDto> resultado = new ArrayList<>();
        for (Libro libro : libros.values()) {
            resultado.add(new LibroResumenDto(libro.getId(), libro.getTitulo()));
        }
        return resultado;
    }

    // ---------- Obtener por id ----------
    public LibroDto buscar(long id) {
        return aDto(obtenerLibro(id));
    }

    // ---------- Prestar ----------
    public LibroDto prestar(long id) {
        Libro libro = obtenerLibro(id);          // 404 si no existe
        if (libro.isPrestado()) {                // 409 si ya está prestado
            throw new ConflictoException("El libro ya está prestado");
        }
        libro.prestar();
        return aDto(libro);
    }

    // ---------- Devolver ----------
    public LibroDto devolver(long id) {
        Libro libro = obtenerLibro(id);          // 404 si no existe
        if (!libro.isPrestado()) {               // 409 si NO está prestado
            throw new ConflictoException("El libro no está prestado");
        }
        libro.devolver();
        return aDto(libro);
    }

    // ---------- Auxiliares ----------
    // Busca el libro o lanza 404. Lo reutilizan buscar, prestar y devolver: la regla "debe existir" se escribe UNA vez.
    private Libro obtenerLibro(long id) {
        Libro libro = libros.get(id);
        if (libro == null) {
            throw new RecursoNoEncontradoException("No existe el libro con id " + id);
        }
        return libro;
    }

    // Conversión modelo -> DTO. Aquí es donde notasInternas se queda fuera.
    private LibroDto aDto(Libro libro) {
        return new LibroDto(libro.getId(), libro.getTitulo(), libro.getAutor(),
                libro.getIsbn(), libro.getAnioPublicacion(), libro.isPrestado());
    }
}
