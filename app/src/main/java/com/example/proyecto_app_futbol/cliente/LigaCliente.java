package com.example.proyecto_app_futbol.cliente;

import com.example.proyecto_app_futbol.model.Liga;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LigaCliente {

    @POST("/ligas")
    Call<Void> createLeague(@Body Liga liga);

}
