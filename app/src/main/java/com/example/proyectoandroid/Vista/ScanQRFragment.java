package com.example.proyectoandroid.Vista;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Button;
import androidx.activity.OnBackPressedCallback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.proyectoandroid.R;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;
import com.google.zxing.ResultPoint;

import java.util.List;
import com.example.proyectoandroid.R;

public class ScanQRFragment extends Fragment {

    private CompoundBarcodeView barcodeView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scan_qr, container, false);

        barcodeView = view.findViewById(R.id.barcode_scanner);

        barcodeView.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                if (result != null && result.getText() != null) {
                    String qrValue = result.getText();

                    // Mostrar mensaje
                    Toast.makeText(getContext(), "QR Escaneado: " + qrValue, Toast.LENGTH_LONG).show();

                    // Redirigir al menú
                    if (getActivity() instanceof MenuAdmin) {
                        ((MenuAdmin) getActivity()).showMenu();
                        getActivity().getSupportFragmentManager().popBackStack();
                    }

                    barcodeView.pause(); // Detener scanner mientras se hace la transición
                }
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) { }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Manejar botón de back del dispositivo
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (getActivity() instanceof MenuAdmin) {
                    ((MenuAdmin) getActivity()).showMenu();
                }
                getParentFragmentManager().popBackStack();
            }
        });

        barcodeView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        barcodeView.pause();
    }


}