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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class EliminarJugador extends AppCompatActivity {
    private Window window;
    private JugadorCliente jugadorCliente;
    private EditText etIdJugador;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_jugador);
        this.setTitle("Eliminar");

        etIdJugador = (EditText) findViewById(R.id.etIdJugador);
        tvMensaje = (TextView) findViewById(R.id.tvMensjaeEliminarJugador);

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
        jugadorCliente = retrofit.create(JugadorCliente.class);
    }

    public void deletePlayer(View view) {
        int idJugador = isNumeric(etIdJugador.getText().toString());

        if (etIdJugador.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar el campo", Toast.LENGTH_SHORT).show();
        } else {
            jugadorCliente.deletePlayer(idJugador).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code() == 209) {
                        tvMensaje.append("Error al eliminar");
                    } else {
                        tvMensaje.append("Eliminado correctamente");
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