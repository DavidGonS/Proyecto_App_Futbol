package com.example.proyecto_app_futbol.usuario.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.example.proyecto_app_futbol.R;

public class MenuBundesliga extends AppCompatActivity {
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bundesliga);
        this.setTitle(R.string.tituloMenuBundesliga);
        init();

    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#6E2722"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6E2722")));
    }
}