package com.example.proyectoandroid.Modelo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Producto {
    @PrimaryKey(autoGenerate = true)
    public int id_producto;

    public String nombre;
    public String categoria;
    public double precio;
    public String estado;
}
