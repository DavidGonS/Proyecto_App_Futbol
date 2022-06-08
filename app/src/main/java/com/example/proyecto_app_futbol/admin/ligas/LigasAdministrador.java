package com.example.proyecto_app_futbol.admin.ligas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.proyecto_app_futbol.R;

public class LigasAdministrador extends AppCompatActivity {
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligas_administrador);

        init();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));
    }

    public void goToAdd(View view) {
        Intent intent = new Intent(this, AnadirLiga.class);
        startActivity(intent);
    }

    public void goToDelete(View view) {
        Intent intent = new Intent(this, EliminarLiga.class);
        startActivity(intent);
    }

    public void goToUpdate(View view) {
        Intent intent = new Intent(this, ModificarLiga.class);
        startActivity(intent);
    }
}