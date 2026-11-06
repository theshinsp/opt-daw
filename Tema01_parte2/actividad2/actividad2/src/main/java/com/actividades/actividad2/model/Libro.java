package com.actividades.actividad2.model;


public class Libro {

    private final long id;
    private final String titulo;
    private final String autor;
    private final String isbn;
    private final int anioPublicacion;
    private boolean prestado;           // lo único que cambia durante la vida del libro
    private final String notasInternas; // dato interno: NO sale en ninguna respuesta

    public Libro(long id, String titulo, String autor, String isbn, int anioPublicacion) {
        // validamos que no puede haber libro con título o autor vacíos, ni año <= 0
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }
        if (anioPublicacion <= 0) {
            throw new IllegalArgumentException("El año de publicación debe ser mayor que 0");
        }
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.prestado = false;   // un libro recién creado NUNCA está prestado, por eso lo ponemos false cuando se crea.
        this.notasInternas = ""; // las pone el personal, nunca el cliente por eso le ponemos el texto vacío
    }

    // solo puede prestarse si NO está prestado asíque si prestar es true lanzamos una excepción en mi caso.
    public void prestar() {
        if (prestado) {
            throw new IllegalStateException("El libro ya está prestado");
        }
        prestado = true;
    }

    // solo puede devolverse si SÍ está prestado, hacemos lo mismo que arriba pero a la inversa.
    public void devolver() {
        if (!prestado) {
            throw new IllegalStateException("El libro no está prestado");
        }
        prestado = false;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public String getNotasInternas() {
        return notasInternas;
    }
}
