package com.example.proyecto_app_futbol.admin.jugadores;

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
import com.example.proyecto_app_futbol.cliente.JugadorCliente;
import com.example.proyecto_app_futbol.model.Jugador;

import java.security.PrivilegedAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ModificarJugador extends AppCompatActivity {
    private Window window;
    private JugadorCliente jugadorCliente;
    private EditText etIdJugador, etNombre, etApellido, etFechaNacimiento, etDorsal,
            etNacionalidad, etPosicion, etValorMercado, etIdEquipo;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_jugador);

        init();
        initRetrofit();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));

        this.setTitle("Modificar");

        etIdJugador = (EditText) findViewById(R.id.etIdJugadorModificar);
        etNombre = (EditText) findViewById(R.id.etNombreModificarJugador);
        etApellido = (EditText) findViewById(R.id.etApellidoModificarJugador);
        etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacModificarJugador);
        etDorsal = (EditText) findViewById(R.id.etDorsalModificarJugador);
        etNacionalidad = (EditText) findViewById(R.id.etNacionalidadModificarJugador);
        etPosicion = (EditText) findViewById(R.id.etPosicionModificarJugador);
        etValorMercado = (EditText) findViewById(R.id.etValorModificarJugador);
        etIdEquipo = (EditText) findViewById(R.id.etIdEquipoModificarJugador);
        tvMensaje = (TextView) findViewById(R.id.tvMensajeModificarJugador);
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:13306")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        jugadorCliente = retrofit.create(JugadorCliente.class);
    }

    public void updatePlayer(View view) {
        int idJugador = isNumeric(etIdJugador.getText().toString());

        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String fechaNacimiento = etFechaNacimiento.getText().toString();
        int dorsal = isNumeric(etDorsal.getText().toString());
        String nacionalidad = etNacionalidad.getText().toString();
        String posicion = etPosicion.getText().toString();
        int valorMercado = isNumeric(etValorMercado.getText().toString());

        int idEquipo = isNumeric(etIdEquipo.getText().toString());

        if (etNombre.getText().toString().isEmpty() || etApellido.getText().toString().isEmpty() ||
                etFechaNacimiento.getText().toString().isEmpty() || etDorsal.getText().toString().isEmpty() ||
                etNacionalidad.getText().toString().isEmpty() || etPosicion.getText().toString().isEmpty() ||
                etValorMercado.getText().toString().isEmpty() || etIdEquipo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            jugadorCliente.updatePlayer(idJugador, new Jugador(null, nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado)).enqueue(new Callback<Void>() {
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