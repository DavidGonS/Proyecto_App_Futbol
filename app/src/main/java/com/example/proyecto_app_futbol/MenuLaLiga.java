package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuLaLiga extends AppCompatActivity {
    private Button btClasificacion, btEquipos, btJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_la_liga);

        this.setTitle(R.string.tituloMenuLaLiga);

        btClasificacion = (Button) findViewById(R.id.btClasificacion);
        btEquipos = (Button) findViewById(R.id.btEquipos);
        btJugadores = (Button) findViewById(R.id.btJugadores);


        goToClasification();
        goToTeams();
    }

    public void goToClasification(){
        btClasificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLaLiga.this, ClasificacionLaLiga.class);
                startActivity(intent);
            }
        });
    }
    public void goToTeams() {
        btEquipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLaLiga.this, EquiposLaLiga.class);
                startActivity(intent);
            }
        });
    }
}