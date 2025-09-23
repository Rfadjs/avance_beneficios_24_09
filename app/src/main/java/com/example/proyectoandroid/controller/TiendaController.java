package com.example.proyectoandroid.controller;
import com.example.proyectoandroid.dao.TiendaDao;
import com.example.proyectoandroid.database.AppDataBase;
import com.example.proyectoandroid.modelo.Tienda;

import java.util.List;
public class TiendaController {

    private final TiendaDao tiendaDao;

    // Constructor recibe la base de datos y obtiene el DAO
    public TiendaController(AppDataBase db) {
        this.tiendaDao = db.tiendaDao();
    }

    // Insertar nueva tienda
    public void agregarTienda(String nombre, String direccion, String horario, String estado, double lat, double lon) {
        Tienda tienda = new Tienda(nombre, direccion, horario, estado);
        tienda.setLat(lat);
        tienda.setLon(lon);
        tiendaDao.insert(tienda);
    }

    // Obtener todas las tiendas
    public List<Tienda> obtenerTiendas() {
        return tiendaDao.getAll();
    }

    // Actualizar tienda existente
    public void actualizarTienda(Tienda tienda) {
        tiendaDao.update(tienda);
    }

    // Eliminar tienda
    public void eliminarTienda(Tienda tienda) {
        tiendaDao.delete(tienda);
    }

    // Buscar tiendas por nombre (opcional)
    public List<Tienda> buscarTiendas(String nombre) {
        return tiendaDao.buscarPorNombre("%" + nombre + "%");
    }
}
