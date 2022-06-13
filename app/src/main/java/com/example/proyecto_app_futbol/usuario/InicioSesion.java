package com.example.proyecto_app_futbol.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyecto_app_futbol.admin.MenuAdministrador;
import com.example.proyecto_app_futbol.R;

public class InicioSesion extends AppCompatActivity {
    private EditText etEmail, etContrasena;
    private Button btIniciar;
    private Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        this.setTitle(R.string.tituloInicioSesion);

        init();
    }

    public void init() {
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#4CAF50"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

    public void iniciarSesion(View view){
        Intent intent = new Intent(this, PaginaPrincipal.class);
        startActivity(intent);
    }

    public void administrador(View view) {
        Intent intent = new Intent(this, MenuAdministrador.class);
        startActivity(intent);
    }
}