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
    public static final String DATABASE_NAME = "appfutbol.sqlite";
    public static final int DATABASE_VERSION = 1;

    public static final String createTeam = "CREATE TABLE IF NOT EXISTS " + Team.TABLE_NAME +
            "("+ Team.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Team.NOMBRE + " VARCHAR(50), " +
            Team.ESTADIO + " VARCHAR(50), " +
            Team.PUNTUACION + " INTEGER, " +
            " FOREIGN KEY (" + Team.ID_LIGA + ") REFERENCES Liga(idLiga) " +
            ")";

    public static final String createPlayer = "CREATE TABLE IF NOT EXISTS " + Player.TABLE_NAME +
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

    public static final String createLeague = "CREATE TABLE IF NOT EXISTS " + League.TABLE_NAME +
            "("+ League.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            League.NOMBRE + " TEXT, " +
            League.PAIS + " TEXT, " +
            "FOREIGN KEY (" + League.ID_EQUIPO + ") REFERENCES Equipos(idEquipo)" +
            ")";


    public static final String createMatch = "CREATE TABLE IF NOT EXISTS " + Match.TABLE_NAME +
            "("+ Match.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Match.NUMERO_JORNADA + " INTEGER, " +
            Match.FECHA + " INTEGER, " +
            Match.RESULTADO + " INTEGER, " +
            "FOREIGN KEY (" + Match.ID_LOCAL + ") REFERENCES Equipos(idEquipo), " +
            "FOREIGN KEY (" + Match.ID_VISITANTE + ") REFERENCES Equipos(idEquipo)" +
            ")";


    public static final String createClasification = "CREATE TABLE IF NOT EXISTS " + Clasification.TABLE_NAME +
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

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTeam);
        sqLiteDatabase.execSQL(createLeague);
        sqLiteDatabase.execSQL(createClasification);
        sqLiteDatabase.execSQL(createPlayer);
        sqLiteDatabase.execSQL(createMatch);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
