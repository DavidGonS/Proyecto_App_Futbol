package com.example.proyecto_app_futbol.cliente;

import com.example.proyecto_app_futbol.model.Liga;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LigaCliente {

    @POST("/ligas")
    Call<Void> createLeague(
            @Body Liga liga
    );

    @DELETE("/ligas/{idLiga}")
    Call<Void> deleteLeague(
            @Query("idLiga") int idLiga
    );

    @PUT("/ligas/{idLiga}")
    Call<Void> updateLeague(
            @Path("idLiga") int idLiga,
            @Body Liga liga
    );
}
