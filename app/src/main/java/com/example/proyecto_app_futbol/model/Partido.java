package com.example.proyecto_app_futbol.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Partido {
    private int numeroJornada;
    private String fecha;
    private int resultado;
    private int idEquipoLocal;
    private int idEquipoVisitante;

    @JsonCreator
    public Partido(
            @JsonProperty("numeroJornada") int numeroJornada,
            @JsonProperty("fecha") String fecha,
            @JsonProperty("resultado") int resultado,
            @JsonProperty("idEquipoLocal") int idEquipoLocal,
            @JsonProperty("idEquipoVisitante") int idEquipoVisitante) {
        this.numeroJornada = numeroJornada;
        this.fecha = fecha;
        this.resultado = resultado;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
    }

    public int getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(int idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public int getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(int idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return numeroJornada == partido.numeroJornada && resultado == partido.resultado && idEquipoLocal == partido.idEquipoLocal && idEquipoVisitante == partido.idEquipoVisitante && Objects.equals(fecha, partido.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroJornada, fecha, resultado, idEquipoLocal, idEquipoVisitante);
    }

    @Override
    public String toString() {
        return "Partido{" +
                "numeroJornada=" + numeroJornada +
                ", fecha='" + fecha + '\'' +
                ", resultado=" + resultado +
                ", idEquipoLocal=" + idEquipoLocal +
                ", idEquipoVisitante=" + idEquipoVisitante +
                '}';
    }
}
