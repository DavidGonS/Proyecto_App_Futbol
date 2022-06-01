package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class JugadoresLaLiga extends AppCompatActivity {
    private TableLayout tlJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_la_liga);
        tlJugadores = (TableLayout) findViewById(R.id.tlJugadores);

        //insertJugador();
        //llenarTabla();
    }

//    public void insertJugador() {
//        DBHelper dbHelper = new DBHelper(this, "appfut.db", null, 1);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        String insert = "insert into Jugadores(nombre, apellido, fechaNacimiento) values ('Juan', 'Perez', '08-09-2000')";
//        db.execSQL(insert);
//    }
//
//    public void llenarTabla(){
//        DBHelper dbHelper = new DBHelper(this, "appfut.db", null, 1);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        // Suponiendo que LaLiga es el id 1
//        Cursor cursor = db.rawQuery("select nombre, apellido, fechaNacimiento " +
//                        "from Jugadores ",
//                null);
//        cursor.moveToFirst();
//
//        View view = LayoutInflater.from(this).inflate(R.layout.item_clasificacion, null, false);
//
//        // Mientras que cursor lea el siguiente registro añade los textview a la vista y los rellena con los datos
//        do {
//            TextView tvNombre = view.findViewById(R.id.tvNombreJugador);
//            TextView tvApellido = view.findViewById(R.id.tvApellidoJUgador);
//            TextView tvFechaNacimiento = view.findViewById(R.id.tvFechaNacimiento);
//
//
//            tvNombre.setText(cursor.getString(0));
//            tvApellido.setText(cursor.getString(1));
//            tvFechaNacimiento.setText(cursor.getString(2));
//
//            tlJugadores.addView(view);
//        }while (cursor.moveToNext());
//
//        db.close();
//    }
}