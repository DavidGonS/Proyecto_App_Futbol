package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_app_futbol.DBHelper;
import com.example.proyecto_app_futbol.PaginaPrincipal.PaginaPrincipal;
import com.example.proyecto_app_futbol.R;
import com.example.proyecto_app_futbol.appfutbol.Tables.Clasification;
import com.example.proyecto_app_futbol.appfutbol.Tables.League;
import com.example.proyecto_app_futbol.appfutbol.Tables.Match;
import com.example.proyecto_app_futbol.appfutbol.Tables.Player;
import com.example.proyecto_app_futbol.appfutbol.Tables.Team;

public class InicioSesion extends AppCompatActivity {
    private EditText etEmail, etContrasena;
    private Button btIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etContrasena = findViewById(R.id.etContrasena);
        btIniciar = findViewById(R.id.btIniciar);

        // No se porque no crea la base de datos
//        DBHelper dbHelper = new DBHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        if (db != null) {
//            Toast.makeText(this, "creada", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "no creada", Toast.LENGTH_SHORT).show();
//        }

    }

    public void iniciarSesion(View view){
        Intent intent = new Intent(this, PaginaPrincipal.class);
        startActivity(intent);
    }
}