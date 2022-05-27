package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PremierLeague extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_premier_league);
        this.setTitle(R.string.tituloMenuPremier);
    }
}