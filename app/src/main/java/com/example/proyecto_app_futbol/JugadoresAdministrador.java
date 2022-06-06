package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JugadoresAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_administrador);
    }

    public void goToAdd(View view) {
        Intent intent = new Intent(this, AnadirJugador.class);
        startActivity(intent);
    }
}