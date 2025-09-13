package com.example.proyectoandroid.Modelo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Sucursal {

    @PrimaryKey(autoGenerate = true)
    public int id_sucursal;

    public String nombre;
    public String direccion;
    public double lat;
    public double lot;
    public String horario;
    public String estado;


}
