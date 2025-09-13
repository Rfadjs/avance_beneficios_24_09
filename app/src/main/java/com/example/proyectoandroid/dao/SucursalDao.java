package com.example.proyectoandroid.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;
import com.example.proyectoandroid.modelo.Sucursal;
@Dao

public interface SucursalDao {
    @Insert
    void insert(Sucursal sucursal);

    @Update
    void update(Sucursal sucursal);

    @Delete
    void delete(Sucursal sucursal);

    @Query("SELECT * FROM Sucursal")
    List<Sucursal> getAll();
}
