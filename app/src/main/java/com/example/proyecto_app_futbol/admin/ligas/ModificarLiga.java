package com.example.proyecto_app_futbol.admin.ligas;

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
import com.example.proyecto_app_futbol.cliente.LigaCliente;
import com.example.proyecto_app_futbol.model.Liga;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ModificarLiga extends AppCompatActivity {
    private Window window;
    private EditText etIdLiga, etNombre, etPais;
    private LigaCliente ligaCliente;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_liga);

        init();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));

        this.setTitle("Modificar");

        etIdLiga = (EditText) findViewById(R.id.etIdLigaModificar);
        etNombre = (EditText) findViewById(R.id.etNombreModificarLiga);
        etPais = (EditText) findViewById(R.id.etPaisModificarLiga);
        tvMensaje = (TextView) findViewById(R.id.tvMensajeModificarLiga);
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        ligaCliente = retrofit.create(LigaCliente.class);
    }

    public void updateLeague(View view) {
        int idLiga = isNumeric(etIdLiga.getText().toString());
        String nombre = etNombre.getText().toString();
        String pais = etPais.getText().toString();

        if (etIdLiga.getText().toString().isEmpty() || etNombre.getText().toString().isEmpty() ||
                etPais.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            ligaCliente.updateLeague(idLiga, new Liga(null, nombre, pais)).enqueue(new Callback<Void>() {
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