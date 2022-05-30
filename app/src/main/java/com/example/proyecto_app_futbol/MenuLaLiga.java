package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MenuLaLiga extends AppCompatActivity {
    private Button btClasificacion, btEquipos, btJugadores;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_la_liga);

        this.setTitle(R.string.tituloMenuLaLiga);
        init();
        goToClasification();
        goToTeams();
    }

    public void init(){
        btClasificacion = (Button) findViewById(R.id.btClasificacion);
        btEquipos = (Button) findViewById(R.id.btEquipos);
        btJugadores = (Button) findViewById(R.id.btJugadores);

        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#4CAF50"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
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