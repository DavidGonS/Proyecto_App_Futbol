package com.example.proyecto_app_futbol.cliente;

import com.example.proyecto_app_futbol.model.Equipo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EquipoCliente {

    @POST("/equipos")
    Call<Void> createTeam(
            @Body Equipo equipo
    );

    @DELETE("/equipos/{idEquipo}")
    Call<Void> deleteTeam(
            @Path("idEquipo") int idEquipo
    );

    @PUT("/equipos/{idEquipo}")
    Call<Void> updateTeam(
            @Path("idEquipo") int idEquipo,
            @Body Equipo equipo
    );
}
