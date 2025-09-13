package com.example.proyectoandroid.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;
import com.example.proyectoandroid.modelo.Visita;

@Dao
public interface VisitaDao {
    @Insert
    void insert(Visita visita);

    @Update
    void update(Visita visita);

    @Delete
    void delete(Visita visita);

    @Query("SELECT * FROM Visita")
    List<Visita> getAll();
}
