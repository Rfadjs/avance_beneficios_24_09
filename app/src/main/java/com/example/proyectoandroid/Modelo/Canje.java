package com.example.proyectoandroid.Modelo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import java.util.Date;

@Entity(foreignKeys = {
        @ForeignKey(entity = Cliente.class, parentColumns = "id_cliente", childColumns = "id_cliente"),
        @ForeignKey(entity = Beneficio.class, parentColumns = "id_beneficio", childColumns = "id_beneficio"),
        @ForeignKey(entity = Sucursal.class, parentColumns = "id_sucursal", childColumns = "id_sucursal")
})
public class Canje {
    @PrimaryKey(autoGenerate = true)
    public int id_canje;

    public int id_cliente;
    public int id_beneficio;
    public int id_sucursal;
    public Date fecha_hora;
    public String codigo_otp;
    public String estado_sync;
}
