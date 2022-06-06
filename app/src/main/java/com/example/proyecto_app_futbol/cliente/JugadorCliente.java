package com.example.proyecto_app_futbol.cliente;

import com.example.proyecto_app_futbol.model.Jugador;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JugadorCliente {

    @POST("/equipos/{idEquipo}/jugadores")
    Call<Void> createPlayerInTeam(
            @Body Jugador jugador,
            @Path("idEquipo") int idEquipo);

    @GET("/jugadores")
    Call<Void> getAllPlayers();
}
