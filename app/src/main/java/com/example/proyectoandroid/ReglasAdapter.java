package com.example.proyectoandroid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReglasAdapter extends RecyclerView.Adapter<ReglasAdapter.ReglaViewHolder> {
    private List<Regla> listaReglas;

    public ReglasAdapter(List<Regla> listaReglas) {
        this.listaReglas = listaReglas;
    }

    @NonNull
    @Override
    public ReglaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_regla, parent, false); // <- aquí va tu layout de item
        return new ReglaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReglaViewHolder holder, int position) {
        Regla regla = listaReglas.get(position);
        holder.textNombre.setText("Nombre: " + regla.getNombre());
        holder.textDescripcion.setText("Descripcion: " + regla.getDescripcion());
        holder.textOtros.setText("Otros: " + regla.getOtros());
    }

    @Override
    public int getItemCount() {
        return listaReglas.size();
    }

    static class ReglaViewHolder extends RecyclerView.ViewHolder {
        TextView textNombre, textDescripcion, textOtros;

        ReglaViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombre = itemView.findViewById(R.id.textNombre);
            textDescripcion = itemView.findViewById(R.id.textDescripcion);
            textOtros = itemView.findViewById(R.id.textOtros);
        }
    }
}
