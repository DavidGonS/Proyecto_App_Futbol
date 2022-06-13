package com.example.proyecto_app_futbol.usuario.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.proyecto_app_futbol.usuario.laliga.PartidosLaLiga;
import com.example.proyecto_app_futbol.R;
import com.example.proyecto_app_futbol.usuario.laliga.ClasificacionLaLiga;
import com.example.proyecto_app_futbol.usuario.laliga.JugadoresLaLiga;

public class MenuLaLiga extends AppCompatActivity {
    private Button btClasificacion, btPartidos, btJugadores;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_la_liga);

        this.setTitle(R.string.tituloMenuLaLiga);
        init();
    }

    public void init(){
        btClasificacion = (Button) findViewById(R.id.btClasificacion);
        btJugadores = (Button) findViewById(R.id.btJugadores);
        btPartidos = (Button) findViewById(R.id.btPartidos);

        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#4CAF50"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

    public void goToPlayers(View view) {
        Intent intent = new Intent(this, JugadoresLaLiga.class);
        startActivity(intent);
    }

    public void goToMatches(View view) {
        Intent intent = new Intent(this, PartidosLaLiga.class);
        startActivity(intent);
    }

    public void goToClasification(View view) {
        Intent intent = new Intent(this, ClasificacionLaLiga.class);
        startActivity(intent);
    }
}