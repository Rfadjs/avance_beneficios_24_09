package com.example.proyectoandroid.Modelo;

public class Tienda {
    private String nombre;
    private String direccion;
    private String horario;
    private String estado;

    public Tienda(String nombre, String direccion, String horario, String estado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.estado = estado;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
