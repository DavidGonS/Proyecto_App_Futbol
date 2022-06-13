package com.example.proyecto_app_futbol.admin.equipos;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_app_futbol.R;
import com.example.proyecto_app_futbol.cliente.EquipoCliente;
import com.example.proyecto_app_futbol.cliente.JugadorCliente;
import com.example.proyecto_app_futbol.model.Equipo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ModificarEquipo extends AppCompatActivity {
    private Window window;
    private EquipoCliente equipoCliente;
    private EditText etIdEquipo, etNombre, etEstadio, etPuntuacion;
    private TextView tvMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_equipo);
        this.setTitle("Modificar equipo");

        etIdEquipo = (EditText) findViewById(R.id.etIdEquipoModificar);
        etNombre = (EditText) findViewById(R.id.etNombreEquipoModificar);
        etEstadio = (EditText) findViewById(R.id.etEstadioModificar);
        etPuntuacion = (EditText) findViewById(R.id.etPuntuacionModificar);
        tvMensaje = (TextView) findViewById(R.id.tvMensajeModificarEquipo);

        init();
        initRetrofit();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        equipoCliente = retrofit.create(EquipoCliente.class);
    }

    public void updateTeam(View view) {
        int idEquipo = isNumeric(etIdEquipo.getText().toString());
        String nombre = etNombre.getText().toString();
        String estadio = etEstadio.getText().toString();
        int puntuacion = isNumeric(etPuntuacion.getText().toString());

        if (etIdEquipo.getText().toString().isEmpty() || etNombre.getText().toString().isEmpty() ||
                etEstadio.getText().toString().isEmpty() || etPuntuacion.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            equipoCliente.updateTeam(idEquipo, new Equipo(nombre, estadio, puntuacion)).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code() == 204) {
                        tvMensaje.append("Error al modificar");
                    } else {
                        tvMensaje.append("Modificado correctamente");
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    tvMensaje.setText(t.getMessage());
                }
            });
        }
    }

    public static int isNumeric(String number){
        int result = 0;
        try{
            if(number != null){
                result = Integer.parseInt(number);
            }
        }catch(NumberFormatException nfe){
            Log.w(TAG, "NFException value: " + number);
        }
        return result;
    }
}