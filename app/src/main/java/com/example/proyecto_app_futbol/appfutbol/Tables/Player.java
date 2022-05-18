package com.example.proyecto_app_futbol.appfutbol.Tables;

import android.provider.BaseColumns;

public class Player implements BaseColumns {
    public static final String TABLE_NAME = "jugadores";

    public static final String ID = "idJugador";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String FECHA_NACIMIENTO = "fechaNacimiento";
    public static final String NACIONALIDAD = "nacionalidad";
    public static final String DORSAL = "dorsal";
    public static final String POSICION = "posicion";
    public static final String VALOR_MERCADO = "valorMercado";
    public static final String ID_EQUIPO = "idEquipo";
}
