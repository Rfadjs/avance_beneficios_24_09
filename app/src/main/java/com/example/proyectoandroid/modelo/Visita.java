package com.example.proyectoandroid.modelo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import java.util.Date;
@Entity(foreignKeys = {
        @ForeignKey(entity = Cliente.class, parentColumns = "id_cliente", childColumns = "id_cliente"),
        @ForeignKey(entity = Tienda.class, parentColumns = "id_tienda", childColumns = "id_tienda")
})
public class Visita {
    @PrimaryKey(autoGenerate = true)
    public int id_visita;

    public int id_cliente;
    public int id_tienda;
    public Date fecha_hora;
    public String origen;
    public String estado_sync;
    public String hash_qr;
}