package com.example.proyectoandroid.Modelo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import java.util.Date;
@Entity
public class Cliente {
    @PrimaryKey(autoGenerate = true)
    public int id_cliente;

    public String nombre;
    public String email;
    public String telefono;
    public Date fecha_nac;
    public String estado;
    public Date creado_en;
}
