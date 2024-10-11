package com.jah.mipractica;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> adaptador;
    Spinner spLista;
    TextView txtMostrar;
    Button btnSalir, btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spLista = findViewById(R.id.spLista);
        txtMostrar = findViewById(R.id.txtMostrar);
        btnSalir = findViewById(R.id.btnSalir);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        adaptador = ArrayAdapter.createFromResource(this, R.array.spLista, android.R.layout.simple_spinner_dropdown_item);
        spLista.setAdapter(adaptador);

        spLista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int indice, long l) {
                equipoElegido();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSiguiente.setOnClickListener(view -> nuevaVentana());
        btnSalir.setOnClickListener(view -> salirAplicacion());

    }

    private void salirAplicacion() {

        Log.i("DAM", "Toda ha salido perfecto");

        finishAffinity();
    }

    public void equipoElegido() {
        txtMostrar.setText(spLista.getSelectedItem().toString());
    }

    private void nuevaVentana() {

        Intent segunda = new Intent(MainActivity.this, VentanaValorar.class);

        segunda.putExtra("valorLista", txtMostrar.getText());
        startActivity(segunda);
    }
}