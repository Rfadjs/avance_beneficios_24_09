package com.example.proyectoandroid.Adaptadores;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoandroid.modelo.Tienda;
import com.example.proyectoandroid.R;

import java.util.List;

public class TiendasAdapter extends RecyclerView.Adapter<TiendasAdapter.TiendaViewHolder> {
    private final List<Tienda> listaTiendas;
    private OnItemClickListener listener;
    private OnMapClickListener mapListener;

    // Interfaz para click en el item
    public interface OnItemClickListener {
        void onItemClick(Tienda tienda);
    }

    // Interfaz para click en el botón “Ver mapa”
    public interface OnMapClickListener {
        void onVerMapaClick(Tienda tienda);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setOnMapClickListener(OnMapClickListener listener) {
        this.mapListener = listener;
    }

    public TiendasAdapter(List<Tienda> listaTiendas) {
        this.listaTiendas = listaTiendas;
    }

    @NonNull
    @Override
    public TiendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tienda, parent, false);
        return new TiendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TiendaViewHolder holder, int position) {
        Tienda tienda = listaTiendas.get(position);

        holder.tvNombre.setText(tienda.getNombre());
        holder.tvDireccion.setText(tienda.getDireccion());
        holder.tvHorario.setText(tienda.getHorario());
        holder.tvEstado.setText(tienda.getEstado());

        // Click en el item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(tienda);
            }
        });

        // Click en el botón “Ver mapa”
        holder.btnVerMapa.setOnClickListener(v -> {
            if (mapListener != null) {
                mapListener.onVerMapaClick(tienda);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaTiendas.size();
    }

    static class TiendaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDireccion, tvHorario, tvEstado;
        Button btnVerMapa;

        public TiendaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvHorario = itemView.findViewById(R.id.tvHorario);
            tvEstado = itemView.findViewById(R.id.tvEstado);
            btnVerMapa = itemView.findViewById(R.id.btnVerMapa);
        }
    }
}
