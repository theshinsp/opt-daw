package com.actividades.actividad6.model;

public class Formulario {
    String nombre;
    String apellidos;
    String correo;
    String pass;

    public Formulario() {
    }

    public Formulario(String nombre, String apellidos, String correo, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
