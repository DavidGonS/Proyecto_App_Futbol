package com.example.proyecto_app_futbol.usuario.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.example.proyecto_app_futbol.R;

public class MenuPremierLeague extends AppCompatActivity {
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_premier_league);
        this.setTitle(R.string.tituloMenuPremier);

        init();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#673AB7"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#673AB7")));
    }
}