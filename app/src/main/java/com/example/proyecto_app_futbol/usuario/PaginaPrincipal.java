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
import com.example.proyecto_app_futbol.usuario.menus.MenuBundesliga;
import com.example.proyecto_app_futbol.usuario.menus.MenuLaLiga;
import com.example.proyecto_app_futbol.usuario.menus.MenuLigueOne;
import com.example.proyecto_app_futbol.usuario.menus.MenuPremierLeague;

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

        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#4CAF50"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

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