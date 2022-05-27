package com.example.proyecto_app_futbol.paginaprincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyecto_app_futbol.Bundesliga;
import com.example.proyecto_app_futbol.MenuLaLiga;
import com.example.proyecto_app_futbol.LigueOne;
import com.example.proyecto_app_futbol.PremierLeague;
import com.example.proyecto_app_futbol.R;

public class PaginaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        this.setTitle(R.string.tituloMenuPrincipal);
    }

    // No se porque pero si meto una actividad en un paquete no la abre pero si esta fuera si
    public void changePremierLeague(View view) {
        Intent intent = new Intent(this, PremierLeague.class);
        startActivity(intent);
    }
    public void changeLaLiga(View view) {
        Intent intent = new Intent(this, MenuLaLiga.class);
        startActivity(intent);
    }
    public void changeBundesliga(View view) {
        Intent intent = new Intent(this, Bundesliga.class);
        startActivity(intent);
    }
    public void changeLigueOne(View view) {
        Intent intent = new Intent(this, LigueOne.class);
        startActivity(intent);
    }
}