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

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class EliminarEquipo extends AppCompatActivity {
    private Window window;
    private EquipoCliente equipoCliente;
    private EditText etIdEquipo;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equipo);

        init();
        initRetrofit();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#3F51B5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F51B5")));

        this.setTitle("Eliminar");

        etIdEquipo = (EditText) findViewById(R.id.etIdEquipoEliminar);
        tvMensaje = (TextView) findViewById(R.id.tvMensajeEliminarEquipo);
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        equipoCliente = retrofit.create(EquipoCliente.class);
    }

    public void deleteTeam(View view) {
        int idEquipo = isNumeric(etIdEquipo.getText().toString());

        if (etIdEquipo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar el campo", Toast.LENGTH_SHORT).show();
        } else {
            equipoCliente.deleteTeam(idEquipo).enqueue(new Callback<Void>() {
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