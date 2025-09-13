package com.example.proyectoandroid.datebase;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(
        entities = {Cliente.class, Sucursal.class, Producto.class, Regla.class, Beneficio.class, Visita.class, Canje.class},
        version = 1
)
@TypeConverters({Converters.class})
public abstract class AppDataBase extends RoomDatabase {
    public abstract ClienteDao clienteDao();
    public abstract SucursalDao sucursalDao();
    public abstract ProductoDao productoDao();
    public abstract ReglaDao reglaDao();
    public abstract BeneficioDao beneficioDao();
    public abstract VisitaDao visitaDao();
    public abstract CanjeDao canjeDao();
}
