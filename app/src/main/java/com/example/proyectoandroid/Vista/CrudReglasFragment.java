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

import com.example.proyectoandroid.Modelo.Regla;
import com.example.proyectoandroid.Adaptadores.ReglasAdapter;
import com.example.proyectoandroid.R;

import java.util.ArrayList;
import java.util.List;

public class CrudReglasFragment extends Fragment {
    private List<Regla> listaReglas;
    private ReglasAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflar el layout del fragment
        View view = inflater.inflate(R.layout.fragment_crud_reglas, container, false);

        // Referencias de la UI desde el "view"
        EditText etNombre = view.findViewById(R.id.editTextText4);
        EditText etDescripcion = view.findViewById(R.id.editTextText3);
        EditText etOtros = view.findViewById(R.id.editTextText5);

        // Limpiar cuando el usuario toque el EditText
        View.OnFocusChangeListener clearOnFocus = (v, hasFocus) -> {
            if (hasFocus) ((EditText) v).setText("");
        };

        etNombre.setOnFocusChangeListener(clearOnFocus);
        etDescripcion.setOnFocusChangeListener(clearOnFocus);
        etOtros.setOnFocusChangeListener(clearOnFocus);

        // RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerReglas);
        listaReglas = new ArrayList<>();
        adapter = new ReglasAdapter(listaReglas);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Botón Agregar
        Button btnAgregar = view.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String descripcion = etDescripcion.getText().toString();
            String otros = etOtros.getText().toString();

            if (!nombre.isEmpty() && !descripcion.isEmpty() && !otros.isEmpty()) {
                listaReglas.add(new Regla(nombre, descripcion, otros));
                adapter.notifyItemInserted(listaReglas.size() - 1);

                // Resetear los campos
                etNombre.setText("Nombre");
                etDescripcion.setText("Descripcion");
                etOtros.setText("Otros");
            }
        });

        Button btnVolver = view.findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> {
            if (getActivity() instanceof MenuAdmin) {
                ((MenuAdmin) getActivity()).showMenu(); // mostrar menú
                getActivity().getSupportFragmentManager().popBackStack(); // quitar fragment
            }
        });

        return view;


    }

}