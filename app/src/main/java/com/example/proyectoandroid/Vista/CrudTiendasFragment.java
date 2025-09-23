package com.example.proyectoandroid.Vista;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.proyectoandroid.R;
import com.example.proyectoandroid.Adaptadores.TiendasAdapter;
import com.example.proyectoandroid.controller.TiendaController;
import com.example.proyectoandroid.database.AppDataBase;
import com.example.proyectoandroid.modelo.Tienda;
import com.google.android.gms.maps.model.LatLng;
import android.widget.Toast;


import java.util.List;



public class CrudTiendasFragment extends Fragment {
    private List<Tienda> listaTiendas;
    private TiendasAdapter adapter;
    private TiendaController tiendaController;
    private Tienda tiendaSeleccionada = null;

    // Variables temporales para lat/lon al crear una tienda nueva
    private double latSeleccion = 0.0;
    private double lonSeleccion = 0.0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crud_tiendas, container, false);

        EditText etNombre = view.findViewById(R.id.etNombre);
        EditText etDireccion = view.findViewById(R.id.etDireccion);
        EditText etHorario = view.findViewById(R.id.etHorario);
        EditText etEstado = view.findViewById(R.id.etEstado);
        EditText etBuscar = view.findViewById(R.id.etBuscar);

        Button btnCrear = view.findViewById(R.id.btnCrear);
        Button btnModificar = view.findViewById(R.id.btnModificar);
        Button btnEliminar = view.findViewById(R.id.btnEliminar);
        Button btnVolver = view.findViewById(R.id.btnVolver);
        Button btnSeleccionarUbicacion = view.findViewById(R.id.btnSeleccionarUbicacion);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerTiendas);

        // Inicializar Room
        AppDataBase db = Room.databaseBuilder(
                        getContext(),
                        AppDataBase.class,
                        "app_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        tiendaController = new TiendaController(db);

        // Cargar datos desde Room
        listaTiendas = tiendaController.obtenerTiendas();
        adapter = new TiendasAdapter(listaTiendas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Selección del item
        adapter.setOnItemClickListener(tienda -> {
            tiendaSeleccionada = tienda;
            etNombre.setText(tienda.getNombre());
            etDireccion.setText(tienda.getDireccion());
            etHorario.setText(tienda.getHorario());
            etEstado.setText(tienda.getEstado());

            // Actualizar las coordenadas temporales
            latSeleccion = tienda.getLat();
            lonSeleccion = tienda.getLon();
        });

        // Botón seleccionar ubicación
        btnSeleccionarUbicacion.setOnClickListener(v -> {
            MapsFragment mapsFragment = new MapsFragment();
            mapsFragment.setOnLocationSelectedListener(location -> {
                latSeleccion = location.latitude;
                lonSeleccion = location.longitude;

                if (tiendaSeleccionada != null) {
                    tiendaSeleccionada.setLat(latSeleccion);
                    tiendaSeleccionada.setLon(lonSeleccion);
                }
            });

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, mapsFragment)
                    .addToBackStack(null)
                    .commit();
        });

        // Crear tienda
        btnCrear.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String direccion = etDireccion.getText().toString();
            String horario = etHorario.getText().toString();
            String estado = etEstado.getText().toString();

            if (!nombre.isEmpty() && !direccion.isEmpty() && !horario.isEmpty() && !estado.isEmpty()) {
                tiendaController.agregarTienda(nombre, direccion, horario, estado, latSeleccion, lonSeleccion);

                listaTiendas.clear();
                listaTiendas.addAll(tiendaController.obtenerTiendas());
                adapter.notifyDataSetChanged();

                etNombre.setText("");
                etDireccion.setText("");
                etHorario.setText("");
                etEstado.setText("");
                tiendaSeleccionada = null;
                latSeleccion = 0.0;
                lonSeleccion = 0.0;
            }
        });

        // Modificar tienda seleccionada
        btnModificar.setOnClickListener(v -> {
            if (tiendaSeleccionada != null) {
                tiendaSeleccionada.setNombre(etNombre.getText().toString());
                tiendaSeleccionada.setDireccion(etDireccion.getText().toString());
                tiendaSeleccionada.setHorario(etHorario.getText().toString());
                tiendaSeleccionada.setEstado(etEstado.getText().toString());
                tiendaSeleccionada.setLat(latSeleccion);
                tiendaSeleccionada.setLon(lonSeleccion);

                tiendaController.actualizarTienda(tiendaSeleccionada);

                listaTiendas.clear();
                listaTiendas.addAll(tiendaController.obtenerTiendas());
                adapter.notifyDataSetChanged();

                etNombre.setText("");
                etDireccion.setText("");
                etHorario.setText("");
                etEstado.setText("");
                tiendaSeleccionada = null;
                latSeleccion = 0.0;
                lonSeleccion = 0.0;
            }
        });

        // Eliminar tienda seleccionada
        btnEliminar.setOnClickListener(v -> {
            if (tiendaSeleccionada != null) {
                tiendaController.eliminarTienda(tiendaSeleccionada);

                listaTiendas.clear();
                listaTiendas.addAll(tiendaController.obtenerTiendas());
                adapter.notifyDataSetChanged();

                etNombre.setText("");
                etDireccion.setText("");
                etHorario.setText("");
                etEstado.setText("");
                tiendaSeleccionada = null;
                latSeleccion = 0.0;
                lonSeleccion = 0.0;
            }
        });
        adapter.setOnMapClickListener(tienda -> {
            double lat = tienda.getLat();
            double lon = tienda.getLon();
            if (lat != 0.0 && lon != 0.0) {
                MapsFragment mapsFragment = new MapsFragment();
                mapsFragment.setInitialLocation(new LatLng(lat, lon));
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, mapsFragment)
                        .addToBackStack(null)
                        .commit();
            } else {
                Toast.makeText(getContext(), "Esta tienda no tiene ubicación asignada", Toast.LENGTH_SHORT).show();
            }
        });



        // Volver al menú
        btnVolver.setOnClickListener(v -> {
            if (getActivity() instanceof MenuAdmin) {
                ((MenuAdmin) getActivity()).showMenu();
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Buscar tiendas
        etBuscar.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_UP) {
                String query = etBuscar.getText().toString();
                listaTiendas.clear();
                listaTiendas.addAll(tiendaController.buscarTiendas(query));
                adapter.notifyDataSetChanged();
            }
            return false;
        });

        return view;
    }
}