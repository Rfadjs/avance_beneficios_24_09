package com.example.proyectoandroid.modelo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;
@Entity

public class Producto {
    @PrimaryKey(autoGenerate = true)
    public int id_producto;

    public String nombre;
    public String categoria;
    public double precio;
    public String estado;
}
