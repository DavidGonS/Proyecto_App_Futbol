package com.example.proyecto_app_futbol;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyecto_app_futbol.appfutbol.Tables.Clasification;
import com.example.proyecto_app_futbol.appfutbol.Tables.League;
import com.example.proyecto_app_futbol.appfutbol.Tables.Match;
import com.example.proyecto_app_futbol.appfutbol.Tables.Player;
import com.example.proyecto_app_futbol.appfutbol.Tables.Team;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "appfutbol.db";
    public static final int DATABASE_VERSION = 1;


    private final String createTeam = "CREATE TABLE IF NOT EXISTS Equipos(idEquipo INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT, estadio TEXT, puntuacion INTEGER, FOREIGN KEY (idLiga) REFERENCES Liga(idLiga))";

    private final String createPlayer = "CREATE TABLE IF NOT EXISTS Jugadores(idJugador INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "nombre TEXT, apellido TEXT, fechaNacimiento INTEGER, dorsal INTEGER, nacionalidad TEXT, posicion TEXT, valorMercado INTEGER, " +
            "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))";

    private final String createLeague = "CREATE TABLE IF NOT EXISTS Ligas(idLiga INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT, pais TEXT, " +
            "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))";

    private final String createMatch = "CREATE TABLE IF NOT EXISTS Partidos(idPartido INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "numeroJornada INTEGER, fecha INTEGER, resultado INTEGER, " +
            "FOREIGN KEY (idEquipoLocal) REFERENCES Equipos(idEquipo)," +
            "FOREIGN KEY (idEquipoVisitante) REFERENCES Equipos(idEquipo))";

    private final String createClasification = "CREATE TABLE IF NOT EXISTS Clasificaciones(idClasificacion INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "posicion INTEGER, partidosGanados INTEGER, partidosEmpatados INTEGER, partidosPerdidos INTEGER, golesFavor INTEGER, golesContra INTEGER, " +
            "FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo))";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createClasification);
        db.execSQL(createLeague);
        db.execSQL(createMatch);
        db.execSQL(createPlayer);
        db.execSQL(createTeam);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
}
