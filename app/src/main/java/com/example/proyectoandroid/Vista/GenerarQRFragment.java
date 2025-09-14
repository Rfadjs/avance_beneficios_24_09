package com.example.proyectoandroid.Vista;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectoandroid.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import com.example.proyectoandroid.R;


public class GenerarQRFragment extends Fragment {

    private static final String ARG_DATOS = "datosQR";
    private String datosQR;

    private ImageView qrImageView;
    private Button btnCerrar;

    public static GenerarQRFragment newInstance(String datosQR) {
        GenerarQRFragment fragment = new GenerarQRFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DATOS, datosQR);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            datosQR = getArguments().getString(ARG_DATOS);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_generar_qr, container, false);

        qrImageView = view.findViewById(R.id.qrImageView);
        btnCerrar = view.findViewById(R.id.btnCerrarQR);

        // Generar QR inmediatamente al abrir el fragment
        if (datosQR != null && !datosQR.isEmpty()) {
            try {
                BarcodeEncoder encoder = new BarcodeEncoder();
                Bitmap bitmap = encoder.encodeBitmap(datosQR, BarcodeFormat.QR_CODE, 400, 400);
                qrImageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Botón para cerrar el fragment
        btnCerrar.setOnClickListener(v -> getActivity().getSupportFragmentManager().popBackStack());

        return view;
    }
}