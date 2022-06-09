package com.example.proyecto_app_futbol.usuario.laliga;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.proyecto_app_futbol.R;
import com.example.proyecto_app_futbol.cliente.EquipoCliente;
import com.example.proyecto_app_futbol.cliente.JugadorCliente;
import com.example.proyecto_app_futbol.model.Jugador;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class JugadoresLaLiga extends AppCompatActivity {
    private JugadorCliente jugadorCliente;
    private TextView tvMensaje, tvNombre, tvApellido, tvFechaNacimiento, tvPosicion, tvNacionalidad, tvDorsal;
    private ArrayAdapter adapter;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_la_liga);
        this.setTitle("Jugadores");

        tvMensaje = (TextView) findViewById(R.id.tvMensajeJugadoresLaLiga);
        tvNombre = (TextView) findViewById(R.id.tvNombreJugador);
        tvApellido = (TextView) findViewById(R.id.tvApellidoJUgador);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvDorsal = (TextView) findViewById(R.id.tvDorsalJugadorLista);
        tvPosicion = (TextView) findViewById(R.id.tvPosicionJugadorLista);
        tvNacionalidad = (TextView) findViewById(R.id.tvNacionalidadJugadorLista);
        adapter = new ArrayAdapter(this, R.layout.item_jugadores);

        init();
        initRetrofit();
        showPlayers();
    }

    public void init(){
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#4CAF50"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        jugadorCliente = retrofit.create(JugadorCliente.class);
    }

    public void showPlayers(){
        jugadorCliente.getAllPlayers().enqueue(new Callback<List<Jugador>>() {
            @Override
            public void onResponse(Call<List<Jugador>> call, Response<List<Jugador>> response) {
                if (!response.isSuccessful()) {
                    tvMensaje.setText("Code: " + response.code());
                    return;
                }

                List<Jugador> jugadores = response.body();
                for (Jugador jugador : jugadores) {
                    tvNombre.setText(jugador.getNombre());
                    tvApellido.setText(jugador.getApellido());
                    tvFechaNacimiento.setText(jugador.getFechaNacimiento());
                    tvDorsal.setText(jugador.getDorsal());
                    tvNacionalidad.setText(jugador.getNacionalidad());
                    tvPosicion.setText(jugador.getPosicion());
                }
            }

            @Override
            public void onFailure(Call<List<Jugador>> call, Throwable t) {
                tvMensaje.setText(t.getMessage());
            }
        });
    }
}