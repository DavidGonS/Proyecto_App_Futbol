package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LigasAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligas_administrador);
    }

    public void goToAdd(View view) {
        Intent intent = new Intent(this, AnadirLiga.class);
        startActivity(intent);
    }
}