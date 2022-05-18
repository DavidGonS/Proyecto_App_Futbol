package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.proyecto_app_futbol.appfutbol.Tables.Clasification;
import com.example.proyecto_app_futbol.appfutbol.Tables.League;
import com.example.proyecto_app_futbol.appfutbol.Tables.Match;
import com.example.proyecto_app_futbol.appfutbol.Tables.Player;
import com.example.proyecto_app_futbol.appfutbol.Tables.Team;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String createTeam = "CREATE TABLE IF NOT EXISTS " + Team.TABLE_NAME +
                            "("+ Team.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                            Team.NOMBRE + " TEXT, " +
                            Team.ESTADIO + " TEXT, " +
                            Team.PUNTUACION + " INTEGER, " +
                            "FOREIGN KEY (" + Team.ID_LIGA + ") REFERENCES Liga(idLiga)" +
                            ")";
        db.execSQL(createTeam);

        String createPlayer = "CREATE TABLE IF NOT EXISTS " + Player.TABLE_NAME +
                "("+ Player.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Player.NOMBRE + " TEXT, " +
                Player.APELLIDO + " TEXT, " +
                Player.FECHA_NACIMIENTO + " INTEGER, " +
                Player.DORSAL + " INTEGER, " +
                Player.NACIONALIDAD + " TEXT, " +
                Player.POSICION + " TEXT, " +
                Player.VALOR_MERCADO + " INTEGER, " +
                "FOREIGN KEY (" + Player.ID_EQUIPO + ") REFERENCES Equipos(idEquipo)" +
                ")";
        db.execSQL(createPlayer);

        String createLeague = "CREATE TABLE IF NOT EXISTS " + League.TABLE_NAME +
                "("+ League.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                League.NOMBRE + " TEXT, " +
                League.PAIS + " TEXT, " +
                "FOREIGN KEY (" + League.ID_EQUIPO + ") REFERENCES Equipos(idEquipo)" +
                ")";
        db.execSQL(createLeague);

        String createMatch = "CREATE TABLE IF NOT EXISTS " + Match.TABLE_NAME +
                "("+ Match.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Match.NUMERO_JORNADA + " INTEGER, " +
                Match.FECHA + " INTEGER, " +
                Match.RESULTADO + " INTEGER, " +
                "FOREIGN KEY (" + Match.ID_LOCAL + ") REFERENCES Equipos(idEquipo), " +
                "FOREIGN KEY (" + Match.ID_VISITANTE + ") REFERENCES Equipos(idEquipo)" +
                ")";
        db.execSQL(createMatch);

        String createClasification = "CREATE TABLE IF NOT EXISTS " + Clasification.TABLE_NAME +
                "("+ Clasification.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Clasification.POSICION + " INTEGER, " +
                Clasification.PARTIDOS_GANADOS + " INTEGER, " +
                Clasification.PARTIDOS_EMPATADOS + " INTEGER, " +
                Clasification.PARTIDOS_PERDIDOS + " INTEGER, " +
                Clasification.GOLES_FAVOR + " INTEGER, " +
                Clasification.GOLES_CONTRA + " INTEGER, " +
                Clasification.DIFERENCIA_GOLES + " INTEGER, " +
                "FOREIGN KEY (" + Clasification.ID_EQUIPO + ") REFERENCES Equipos(idEquipo)" +
                ")";
        db.execSQL(createClasification);
    }
}