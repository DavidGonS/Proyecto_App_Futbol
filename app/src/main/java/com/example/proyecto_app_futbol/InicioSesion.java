package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyecto_app_futbol.paginaprincipal.PaginaPrincipal;

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
        Intent intent = new Intent(this, PantallaAdministrador.class);
        startActivity(intent);
    }

//    public void createDatabaseAndTables() {
//        DBHelper dbHelper = new DBHelper(this, "appfut.sql", null, 1);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.execSQL("CREATE TABLE IF NOT EXISTS Equipos (" +
//                "idEquipo INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "nombre TEXT, " +
//                "estadio TEXT, " +
//                "puntuacion INTEGER, " +
//                "idLiga INTEGER, " +
//                "FOREIGN KEY (idLiga) REFERENCES Liga(idLiga))");
//
//        db.execSQL("CREATE TABLE IF NOT EXISTS Jugadores (idJugador INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "nombre TEXT, " +
//                "apellido TEXT, " +
//                "fechaNacimiento TEXT, " +
//                "dorsal INTEGER, " +
//                "nacionalidad TEXT, " +
//                "posicion TEXT, " +
//                "valorMercado INTEGER, " +
//                "idEquipo INTEGER, " +
//                "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))");
//
//        db.execSQL("CREATE TABLE IF NOT EXISTS Ligas(idLiga INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "nombre TEXT, pais TEXT, " +
//                "idEquipo INTEGER, " +
//                "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))");
//
//        db.execSQL("CREATE TABLE IF NOT EXISTS Partidos(idPartido INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "numeroJornada INTEGER, " +
//                "fecha INTEGER, " +
//                "resultado INTEGER, " +
//                "idEquipoLocal INTEGER, " +
//                "idEquipoVisitante INTEGER," +
//                "FOREIGN KEY (idEquipoLocal) REFERENCES Equipos(idEquipo)," +
//                "FOREIGN KEY (idEquipoVisitante) REFERENCES Equipos(idEquipo))");
//
//        db.execSQL("CREATE TABLE IF NOT EXISTS Clasificaciones(idClasificacion INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "posicion INTEGER, " +
//                "nombre TEXT, " +
//                "partidosJugados INTEGER, " +
//                "partidosGanados INTEGER, " +
//                "partidosEmpatados INTEGER, " +
//                "partidosPerdidos INTEGER, " +
//                "golesFavor INTEGER, " +
//                "golesContra INTEGER, " +
//                "idEquipo INTEGER, " +
//                "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))");
//    }
}