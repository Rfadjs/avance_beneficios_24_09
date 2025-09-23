package com.example.proyectoandroid.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.proyectoandroid.modelo.Tienda;
import java.util.List;
@Dao
public interface TiendaDao {@Insert
void insert(Tienda tienda);

    @Update
    void update(Tienda tienda);

    @Delete
    void delete(Tienda tienda);

    @Query("SELECT * FROM Tienda")
    List<Tienda> getAll();

    // Búsqueda por nombre
    @Query("SELECT * FROM Tienda WHERE nombre LIKE :nombre")
    List<Tienda> buscarPorNombre(String nombre);
}
