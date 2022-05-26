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
        createDatabaseAndTables();

    }

    public void iniciarSesion(View view){
        Intent intent = new Intent(this, PaginaPrincipal.class);
        startActivity(intent);
    }

    public void createDatabaseAndTables() {
        DBHelper dbHelper = new DBHelper(this, "appfut.sqlite", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS Equipos (" +
                "idEquipo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "estadio TEXT, " +
                "puntuacion INTEGER, " +
                "FOREIGN KEY (idLiga) REFERENCES Liga(idLiga))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Jugadores (idJugador INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "apellido TEXT, " +
                "fechaNacimiento INTEGER, " +
                "dorsal INTEGER, " +
                "nacionalidad TEXT, " +
                "posicion TEXT, " +
                "valorMercado INTEGER, " +
                "idEquipo INTEGER, " +
                "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Ligas(idLiga INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, pais TEXT, " +
                "idEquipo INTEGER, " +
                "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Partidos(idPartido INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "numeroJornada INTEGER, fecha INTEGER, resultado INTEGER, " +
                "idEquipoLocal INTEGER, " +
                "idEquipoVisitante," +
                "FOREIGN KEY (idEquipoLocal) REFERENCES Equipos(idEquipo)," +
                "FOREIGN KEY (idEquipoVisitante) REFERENCES Equipos(idEquipo))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Clasificaciones(idClasificacion INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "posicion INTEGER, " +
                "partidosGanados INTEGER, " +
                "partidosEmpatados INTEGER, " +
                "partidosPerdidos INTEGER, " +
                "golesFavor INTEGER, " +
                "golesContra INTEGER, " +
                "idEquipo INTEGER, " +
                "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))");
    }
}