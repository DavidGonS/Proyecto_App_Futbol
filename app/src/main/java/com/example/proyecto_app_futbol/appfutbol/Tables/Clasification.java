package com.example.proyecto_app_futbol.appfutbol.Tables;

import android.provider.BaseColumns;

public class Clasification implements BaseColumns {
    public static final String TABLE_NAME = "clasificacion";

    public static final String ID = "idClasificacion";
    public static final String POSICION = "nombre";
    public static final String ID_EQUIPO = "idEquipo";
    public static final String PARTIDOS_GANADOS = "partidosGanados";
    public static final String PARTIDOS_EMPATADOS = "partidosEmpatados";
    public static final String PARTIDOS_PERDIDOS = "partidosPerdidos";
    public static final String GOLES_FAVOR = "golesFavor";
    public static final String GOLES_CONTRA = "golesContra";
    public static final String DIFERENCIA_GOLES = "diferenciaGoles";
}
