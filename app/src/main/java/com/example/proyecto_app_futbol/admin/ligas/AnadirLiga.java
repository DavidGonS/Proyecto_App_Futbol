package com.example.proyecto_app_futbol.admin.ligas;

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
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_liga);


        init();
        initRetrofit();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));

        this.setTitle("Añadir");

        etNombre = (EditText) findViewById(R.id.etNombreLiga);
        etPais = (EditText) findViewById(R.id.etPaisLiga);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        ligaCliente = retrofit.create(LigaCliente.class);
    }

    public void createLeague(View view) {
        String nombre = etNombre.getText().toString();
        String pais = etPais.getText().toString();

        if (etNombre.getText().toString().isEmpty() || etPais.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            ligaCliente.createLeague(new Liga(null,nombre, pais)).enqueue(new Callback<Void>() {
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
                    tvMensaje.setText(t.getMessage());
                }
            });
        }
    }
}