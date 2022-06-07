package com.example.proyecto_app_futbol.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.proyecto_app_futbol.R;

public class ClasificacionLaLiga extends AppCompatActivity {
    private TableLayout tlClasificacion;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion_la_liga);
        this.setTitle(R.string.tituloClasificacion);

        init();
        //llenarTabla();
    }

    public void init(){
        tlClasificacion = (TableLayout) findViewById(R.id.tlJugadores);

        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#4CAF50"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

    // Por ahora no funciona porque creo que tienen que haber datos metidos
    // Este metodo habria que hacerlo en todas las pantallas que se quiera mostrar datos en una tabla
//    public void llenarTabla(){
//        DBHelper dbHelper = new DBHelper(this, "appfut.db", null, 1);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        // Suponiendo que LaLiga es el id 1
//        Cursor cursor = db.rawQuery("select posicion, nombre, partidosJugados, partidosGanados, partidosEmpatados, partidosPerdidos, golesFavor, golesContra " +
//                "from Clasificaciones " +
//                "where idClasificacion=1",
//                null);
//        cursor.moveToFirst();
//
//        View view = LayoutInflater.from(this).inflate(R.layout.item_clasificacion, null, false);
//
//        // Mientras que cursor lea el siguiente registro añade los textview a la vista y los rellena con los datos
//        do {
//            TextView tvPosicion = view.findViewById(R.id.tvPosicion);
//            TextView tvNombre = view.findViewById(R.id.tvNombre);
//            TextView tvPartidosJugados = view.findViewById(R.id.tvParJugados);
//            TextView tvPartidosGanados = view.findViewById(R.id.tvPartGanados);
//            TextView tvPartidosEmpatados = view.findViewById(R.id.tvPartEmpatados);
//            TextView tvPartidosPerdidos = view.findViewById(R.id.tvPartPerdidos);
//            TextView tvGolesFavor = view.findViewById(R.id.tvGolesFavor);
//            TextView tvGolesContra = view.findViewById(R.id.tvGolesContra);
//
//            tvPosicion.setText(cursor.getString(0));
//            tvNombre.setText(cursor.getString(1));
//            tvPartidosJugados.setText(cursor.getString(2));
//            tvPartidosGanados.setText(cursor.getString(3));
//            tvPartidosEmpatados.setText(cursor.getString(4));
//            tvPartidosPerdidos.setText(cursor.getString(5));
//            tvGolesFavor.setText(cursor.getString(6));
//            tvGolesContra.setText(cursor.getString(7));
//
//            tlClasificacion.addView(view);
//        }while (cursor.moveToNext());
//
//        db.close();
//    }
}