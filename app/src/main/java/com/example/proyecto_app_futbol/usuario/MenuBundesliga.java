package com.example.proyecto_app_futbol.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyecto_app_futbol.R;

public class MenuBundesliga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bundesliga);
        this.setTitle(R.string.tituloMenuBundesliga);

    }
}