package com.example.proyectoandroid.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;
import com.example.proyectoandroid.modelo.Canje;

@Dao

public interface CanjeDao {
    @Insert
    void insert(Canje canje);

    @Update
    void update(Canje canje);

    @Delete
    void delete(Canje canje);

    @Query("SELECT * FROM Canje")
    List<Canje> getAll();
}
