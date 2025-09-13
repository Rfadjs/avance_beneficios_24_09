package com.example.proyectoandroid.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;
@Dao

public interface BeneficioDao {
    @Insert
    void insert(Beneficio beneficio);

    @Update
    void update(Beneficio beneficio);

    @Delete
    void delete(Beneficio beneficio);

    @Query("SELECT * FROM Beneficio")
    List<Beneficio> getAll();
}
