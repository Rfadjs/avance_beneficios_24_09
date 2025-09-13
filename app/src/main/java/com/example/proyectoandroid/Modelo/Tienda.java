package com.example.proyectoandroid.Modelo;
import androidx.room.Entity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tienda {@PrimaryKey(autoGenerate = true)
private int id_tienda;

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
    public int getId_tienda() { return id_tienda; }
    public void setId_tienda(int id_tienda) { this.id_tienda = id_tienda; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
