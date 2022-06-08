package com.example.proyecto_app_futbol.admin.ligas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.example.proyecto_app_futbol.R;

public class ModificarLiga extends AppCompatActivity {
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_liga);

        init();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));
    }
}