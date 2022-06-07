package com.example.proyecto_app_futbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_app_futbol.R;
import com.example.proyecto_app_futbol.cliente.LigaCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class EliminarLiga extends AppCompatActivity {
    private LigaCliente ligaCliente;
    private EditText etIdLiga;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_liga);

        etIdLiga = (EditText) findViewById(R.id.etIdLiga);
        tvMensaje = (TextView) findViewById(R.id.tvMensajeEliminarLiga);
        initRetrofit();
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        ligaCliente = retrofit.create(LigaCliente.class);
    }

    public void deleteLeague(View view) {
        int idEquipo = Integer.parseInt(etIdLiga.getText().toString());

        if (etIdLiga.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar el campo", Toast.LENGTH_SHORT).show();
        } else {
            ligaCliente.deleteLeague(idEquipo).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code() == 204) {
                        tvMensaje.append("Error al eliminar");
                    } else {
                        tvMensaje.append("Eliminada correctamente");
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
    }
}