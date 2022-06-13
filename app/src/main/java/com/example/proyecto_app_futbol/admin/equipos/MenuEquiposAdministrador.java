package com.example.proyecto_app_futbol.admin.equipos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.proyecto_app_futbol.R;
import com.example.proyecto_app_futbol.admin.jugadores.EliminarJugador;

public class MenuEquiposAdministrador extends AppCompatActivity {
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_equipos_administrador);

        init();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));
        this.setTitle("Menu Equipos");
    }

    public void goToAdd(View view) {
        Intent intent = new Intent(this, AnadirEquipo.class);
        startActivity(intent);
    }

    public void goToUpdate(View view) {
        Intent intent = new Intent(this, ModificarEquipo.class);
        startActivity(intent);
    }

    public void goToDelete(View view) {
        Intent intent = new Intent(this, EliminarEquipo.class);
        startActivity(intent);
    }
}