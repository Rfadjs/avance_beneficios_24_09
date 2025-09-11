package com.example.proyectoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;

public class CrudReglas extends AppCompatActivity {
    private List<Regla> listaReglas;
    private ReglasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crud_reglas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> finish());

        EditText etNombre = findViewById(R.id.editTextText4);
        EditText etDescripcion = findViewById(R.id.editTextText3);
        EditText etOtros = findViewById(R.id.editTextText5);

        // Limpiar cuando el usuario toque el EditText
        View.OnFocusChangeListener clearOnFocus = (v, hasFocus) -> {
            if (hasFocus) {
                ((EditText) v).setText("");
            }
        };

        etNombre.setOnFocusChangeListener(clearOnFocus);
        etDescripcion.setOnFocusChangeListener(clearOnFocus);
        etOtros.setOnFocusChangeListener(clearOnFocus);

        // RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerReglas);
        listaReglas = new ArrayList<>();
        adapter = new ReglasAdapter(listaReglas);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Botón Agregar
        Button btnAgregar = findViewById(R.id.btnAgregar);
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
    }
}