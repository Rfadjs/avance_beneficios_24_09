package com.example.proyectoandroid.Vista;

import android.os.Bundle;
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

import com.example.proyectoandroid.modelo.Tienda;
import com.example.proyectoandroid.Adaptadores.TiendasAdapter;
import com.example.proyectoandroid.R;

import java.util.ArrayList;
import java.util.List;

public class CrudTiendasFragmen extends Fragment {
    private List<Tienda> listaTiendas;
    private TiendasAdapter adapter;

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

        RecyclerView recyclerView = view.findViewById(R.id.recyclerTiendas);
        listaTiendas = new ArrayList<>();
        adapter = new TiendasAdapter(listaTiendas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        btnCrear.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String direccion = etDireccion.getText().toString();
            String horario = etHorario.getText().toString();
            String estado = etEstado.getText().toString();

            if (!nombre.isEmpty() && !direccion.isEmpty() && !horario.isEmpty() && !estado.isEmpty()) {
                listaTiendas.add(new Tienda(nombre, direccion, horario, estado));
                adapter.notifyItemInserted(listaTiendas.size() - 1);

                etNombre.setText("");
                etDireccion.setText("");
                etHorario.setText("");
                etEstado.setText("");
            }
        });
        Button btnVolver = view.findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> {
            if (getActivity() instanceof MenuAdmin) {
                ((MenuAdmin) getActivity()).showMenu(); // mostrar menú
                getActivity().getSupportFragmentManager().popBackStack(); // quitar fragment
            }
        });

        // Implementar btnModificar y btnEliminar según tu lógica
        return view;
    }
}