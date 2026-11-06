package com.actividades.actividad2.dto;

public class LibroDto {

    private final long id;
    private final String titulo;
    private final String autor;
    private final String isbn;
    private final int anioPublicacion;
    private final boolean prestado;

    public LibroDto(long id, String titulo, String autor, String isbn, int anioPublicacion, boolean prestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.prestado = prestado;
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
    }   // boolean -> "is" + Nombre -> clave JSON "prestado"
}
