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
import com.example.proyecto_app_futbol.cliente.LigaCliente;
import com.example.proyecto_app_futbol.model.Jugador;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class AnadirJugador extends AppCompatActivity {
    private JugadorCliente jugadorCliente;
    private EditText etNombre, etApellido, etFechaNacimiento, etDorsal,
            etNacionalidad, etPosicion, etValorMercado, etIdEquipo;
    private TextView tvMensaje;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_jugador);

        init();
        initRetrofit();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));

        this.setTitle("Añadir");

        etNombre = (EditText) findViewById(R.id.etNombreAnadirJugador);
        etApellido = (EditText) findViewById(R.id.etApellidoAnadirJugador);
        etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacimientoAnadirJugador);
        etDorsal = (EditText) findViewById(R.id.etDorsalAnadirJugador);
        etNacionalidad = (EditText) findViewById(R.id.etNacionalidadAnadirJugador);
        etPosicion = (EditText) findViewById(R.id.etPosicionAnadirJugador);
        etValorMercado = (EditText) findViewById(R.id.etValorMercadoAnadirJugador);
        etIdEquipo = (EditText) findViewById(R.id.etIdEquipoAnadirJugador);
        tvMensaje = (TextView) findViewById(R.id.tvMensajeAnadirJugador);
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        jugadorCliente = retrofit.create(JugadorCliente.class);
    }

    public void createPlayerInTeam(View view) {
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
                etValorMercado.getText().toString().isEmpty() || etIdEquipo.getText().toString().isEmpty())  {
            Toast.makeText(this, "Debes rellenar todos lo campos", Toast.LENGTH_SHORT).show();
        } else {
            jugadorCliente.createPlayerInTeam(
                    new Jugador(null, nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado),
                    idEquipo)
                    .enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code() == 409) {
                        tvMensaje.append("Jugador duplicado");
                    } else {
                        tvMensaje.append("Creado correctamente");
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    tvMensaje.setText(t.getMessage());
                }
            });
        }
    }

    // Método que verifica si lo que se introduce es un numero
    // Cualquier int que se vaya a introducir un dato debe tener este metodo
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