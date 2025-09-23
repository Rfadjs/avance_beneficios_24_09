package com.example.proyectoandroid.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.proyectoandroid.dao.TiendaDao;
import com.example.proyectoandroid.modelo.Cliente;
import com.example.proyectoandroid.modelo.Producto;
import com.example.proyectoandroid.modelo.Regla;
import com.example.proyectoandroid.modelo.Beneficio;
import com.example.proyectoandroid.modelo.Tienda;
import com.example.proyectoandroid.modelo.Visita;
import com.example.proyectoandroid.modelo.Canje;

import com.example.proyectoandroid.dao.ClienteDao;
import com.example.proyectoandroid.dao.ProductosDao;
import com.example.proyectoandroid.dao.ReglaDao;
import com.example.proyectoandroid.dao.BeneficioDao;
import com.example.proyectoandroid.dao.VisitaDao;
import com.example.proyectoandroid.dao.CanjeDao;

@Database(
        entities = {Cliente.class, Tienda.class, Producto.class, Regla.class, Beneficio.class, Visita.class, Canje.class},
        version = 3
)
@TypeConverters({Converters.class})
public abstract class AppDataBase extends RoomDatabase {
    public abstract ClienteDao clienteDao();
    public abstract TiendaDao tiendaDao();
    public abstract ProductosDao productoDao();
    public abstract ReglaDao reglaDao();
    public abstract BeneficioDao beneficioDao();
    public abstract VisitaDao visitaDao();
    public abstract CanjeDao canjeDao();
}
