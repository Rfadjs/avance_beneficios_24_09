package com.example.proyectoandroid.controller;

import com.example.proyectoandroid.database.AppDataBase;
import com.example.proyectoandroid.dao.ReglaDao;
import com.example.proyectoandroid.modelo.Regla;

import java.util.List;

public class ReglaController {
    private final ReglaDao reglaDao;

    // Constructor recibe la base de datos y obtiene el DAO
    public ReglaController(AppDataBase db) {
        this.reglaDao = db.reglaDao();
    }

    // Insertar una nueva regla
    public void agregarRegla(String nombre, String descripcion, String otros) {
        Regla regla = new Regla(nombre, descripcion, otros);
        reglaDao.insert(regla);
    }

    // Obtener todas las reglas
    public List<Regla> obtenerReglas() {
        return reglaDao.getAll();
    }

    // Actualizar una regla existente
    public void actualizarRegla(Regla regla) {
        reglaDao.update(regla);
    }

    // Eliminar una regla
    public void eliminarRegla(Regla regla) {
        reglaDao.delete(regla);
    }
}
