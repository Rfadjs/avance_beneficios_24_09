package com.example.proyectoandroid.Vista;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectoandroid.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback {
    private LatLng initialLocation;
    private GoogleMap mMap;
    private LatLng seleccion;
    private OnLocationSelectedListener listener;

    // NUEVO: posición inicial para mostrar mapa
    private LatLng initialPosition;

    public interface OnLocationSelectedListener {
        void onLocationSelected(LatLng location);
    }
    public void setInitialLocation(LatLng location) {
        this.initialLocation = location;
    }


    public void setOnLocationSelectedListener(OnLocationSelectedListener listener) {
        this.listener = listener;
    }

    public void setInitialPosition(LatLng position) {
        this.initialPosition = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Botón confirmar ubicación solo si vamos a asignar
        Button btnConfirmar = view.findViewById(R.id.btnConfirmarUbicacion);
        btnConfirmar.setOnClickListener(v -> {
            if (seleccion != null && listener != null) {
                listener.onLocationSelected(seleccion);
                getParentFragmentManager().popBackStack(); // cerrar el mapa
            }
        });

        // Si solo es visualizar, se puede ocultar el botón desde fuera
        btnConfirmar.setVisibility(listener != null ? View.VISIBLE : View.GONE);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng inicio = initialLocation != null ? initialLocation : new LatLng(-34, 151);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(inicio, 10));

        if (initialLocation != null) {
            mMap.addMarker(new MarkerOptions().position(initialLocation).title("Ubicación de la tienda"));
        }

        mMap.setOnMapClickListener(latLng -> {
            seleccion = latLng;
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(latLng).title("Ubicación seleccionada"));
        });
    }
}