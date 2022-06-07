package com.example.proyecto_app_futbol.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyecto_app_futbol.R;
import com.example.proyecto_app_futbol.admin.jugadores.JugadoresAdministrador;
import com.example.proyecto_app_futbol.admin.ligas.LigasAdministrador;

public class MenuAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);
    }

    public void goToLigas(View view) {
        Intent intent = new Intent(this, LigasAdministrador.class);
        startActivity(intent);
    }

    public void goToPlayers(View view) {
        Intent intent = new Intent(this, JugadoresAdministrador.class);
        startActivity(intent);
    }
}