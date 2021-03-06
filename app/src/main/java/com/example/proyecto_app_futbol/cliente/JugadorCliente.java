package com.example.proyecto_app_futbol.cliente;

import com.example.proyecto_app_futbol.model.Jugador;
import com.example.proyecto_app_futbol.model.JugadorList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JugadorCliente {

    @POST("/equipos/{idEquipo}/jugadores")
    Call<Void> createPlayerInTeam(
            @Body Jugador jugador,
            @Path("idEquipo") int idEquipo
    );

    @GET("/jugadores")
    Call<List<Jugador>> getAllPlayers();

    @GET("/jugadores/{idJugador}")
    Call<Jugador> getPlayerById(
            @Path("idJugador") int id
    );

    @DELETE("/jugadores/{idJugador}")
    Call<Void> deletePlayer(
            @Path("idJugador") int idJugador
    );

    @PUT("/jugadores/{idJugador}")
    Call<Void> updatePlayer(
            @Path("idJugador") int idJugador,
            @Body Jugador jugador
    );

    @GET("/equipos/{idEquipo}/jugadores")
    Call<List<JugadorList>> getJugadorByIdEquipo(@Path("idEquipo") int idEquipo);
}
