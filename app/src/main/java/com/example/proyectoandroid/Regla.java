package com.example.proyectoandroid;

public class Regla {
    private String nombre;
    private String descripcion;
    private String otros;

    public Regla(String nombre, String descripcion, String otros) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.otros = otros;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getOtros() { return otros; }
}
