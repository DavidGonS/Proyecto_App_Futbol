package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EquiposLaLiga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_la_liga);
        this.setTitle(R.string.tituloEquipos);

    }
}