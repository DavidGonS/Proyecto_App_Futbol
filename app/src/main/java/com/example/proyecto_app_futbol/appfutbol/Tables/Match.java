package com.example.proyecto_app_futbol.appfutbol.Tables;

import android.provider.BaseColumns;

public class Match implements BaseColumns {
    public static final String TABLE_NAME = "partidos";

    public static final String ID = "idPartido";
    public static final String NUMERO_JORNADA = "numeroJornada";
    public static final String FECHA = "fecha";
    public static final String RESULTADO = "resultado";
    public static final String ID_LOCAL = "idEquipoLocal";
    public static final String ID_VISITANTE = "idEquipoVisitante";
}
