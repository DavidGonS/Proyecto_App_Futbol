package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_app_futbol.cliente.LigaCliente;
import com.example.proyecto_app_futbol.model.Liga;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class AnadirLiga extends AppCompatActivity {
    private LigaCliente ligaCliente;
    private EditText etNombre, etPais;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_liga);

        etNombre = (EditText) findViewById(R.id.etNombreLiga);
        etPais = (EditText) findViewById(R.id.etPaisLiga);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);

        initRetrofit();
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        ligaCliente = retrofit.create(LigaCliente.class);
    }

    public void createLeague(View view) {
        if (etNombre.getText().toString().isEmpty() || etPais.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            String nombre = etNombre.getText().toString();
            String pais = etPais.getText().toString();
            ligaCliente.createLeague(new Liga(nombre, pais)).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code() == 409){
                        tvMensaje.append("Liga duplicada");
                    } else {
                        tvMensaje.append("Liga creada");
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e("MainActivity", t.getMessage(), t);
                }
            });
        }
    }
}