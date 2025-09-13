package com.example.proyectoandroid.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;
@Dao

public interface ClienteDao {
    @Insert
    void insert(Cliente cliente);

    @Update
    void update(Cliente cliente);

    @Delete
    void delete(Cliente cliente);

    @Query("SELECT * FROM Cliente")
    List<Cliente> getAll();
}
