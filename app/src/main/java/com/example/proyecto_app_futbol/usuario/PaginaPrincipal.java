package com.example.proyecto_app_futbol.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.proyecto_app_futbol.R;

public class PaginaPrincipal extends AppCompatActivity {
    private ImageButton ibLaLiga, ibBundesliga, ibPremier, ibLigueOne;
    private Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);

        this.setTitle(R.string.tituloMenuPrincipal);

        init();

    }

    public void init() {
        ibLaLiga = (ImageButton) findViewById(R.id.ibLaLiga);
        ibBundesliga = (ImageButton) findViewById(R.id.ibBundesliga);
        ibPremier = (ImageButton) findViewById(R.id.ibPremier);
        ibLigueOne = (ImageButton) findViewById(R.id.ibLigue1);

        ibLigueOne.setBackgroundDrawable(null);
        ibLaLiga.setBackgroundDrawable(null);
        ibBundesliga.setBackgroundDrawable(null);
        ibPremier.setBackgroundDrawable(null);

        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#4CAF50"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

    // No se porque pero si meto una actividad en un paquete no la abre pero si esta fuera si
    public void changePremierLeague(View view) {
        Intent intent = new Intent(this, MenuPremierLeague.class);
        startActivity(intent);
    }
    public void changeLaLiga(View view) {
        Intent intent = new Intent(this, MenuLaLiga.class);
        startActivity(intent);
    }
    public void changeBundesliga(View view) {
        Intent intent = new Intent(this, MenuBundesliga.class);
        startActivity(intent);
    }
    public void changeLigueOne(View view) {
        Intent intent = new Intent(this, MenuLigueOne.class);
        startActivity(intent);
    }
}