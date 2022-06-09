package com.example.proyecto_app_futbol.cliente;

import com.example.proyecto_app_futbol.model.Clasificacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClasificacionCliente {

    @GET("/clasificaciones")
    Call<List<Clasificacion>> getClasification();
}
