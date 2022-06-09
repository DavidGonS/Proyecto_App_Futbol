package com.example.proyecto_app_futbol.admin.jugadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.proyecto_app_futbol.R;

public class JugadoresAdministrador extends AppCompatActivity {
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_administrador);
        this.setTitle("Jugadores");
        init();
    }

    public void goToAdd(View view) {
        Intent intent = new Intent(this, AnadirJugador.class);
        startActivity(intent);
    }

    public void goToUpdate(View view) {
        Intent intent = new Intent(this, ModificarJugador.class);
        startActivity(intent);
    }

    public void goToDelete(View view) {
        Intent intent = new Intent(this, EliminarJugador.class);
        startActivity(intent);
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));
    }
}