package com.example.proyectoandroid.Modelo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import java.util.Date;
@Entity(foreignKeys = {
        @ForeignKey(entity = Regla.class, parentColumns = "id_regla", childColumns = "regla"),
        @ForeignKey(entity = Producto.class, parentColumns = "id_producto", childColumns = "producto_premio")
})
public class Beneficio {
    @PrimaryKey(autoGenerate = true)
    public int id_beneficio;

    public int regla;
    public int producto_premio;
    public String nombre;
    public String tipo;
    public int requisito_visitas;
    public double descuento_pct;
    public Date vigencia_ini;
    public Date vigencia_fin;
    public String estado;
}