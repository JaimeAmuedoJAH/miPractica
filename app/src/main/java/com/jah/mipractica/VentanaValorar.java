package com.jah.mipractica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class VentanaValorar extends AppCompatActivity {

    Button btnVolver;
    RatingBar rbRating;
    TextView txtMostrarValoracion;
    String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.valorar_ventana);

        Intent recuperarValor = getIntent();
        valor = recuperarValor.getStringExtra("valorLista");

        btnVolver = findViewById(R.id.btnVolver);
        rbRating = findViewById(R.id.rbRating);
        txtMostrarValoracion = findViewById(R.id.txtMostrarValoracion);

        rbRating.setOnRatingBarChangeListener((ratingBar, v, b) -> mostrarValoracion());

        btnVolver.setOnClickListener(view -> volver());
    }

    private void mostrarValoracion() {

        int valoracion = (int) rbRating.getRating();

        txtMostrarValoracion.setText("Has valorado al " + valor + " con " + valoracion + " estrellas.");
    }

    private void volver() {

        Intent main = new Intent(VentanaValorar.this, MainActivity.class);

        startActivity(main);
    }
}
