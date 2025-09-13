package com.example.proyectoandroid.modelo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;

@Entity
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
