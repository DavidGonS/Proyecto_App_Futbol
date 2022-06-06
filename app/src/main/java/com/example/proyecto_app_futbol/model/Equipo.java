package com.example.proyecto_app_futbol.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Equipo {
    private String nombre;
    private String estadio;
    private int puntuacion;

    @JsonCreator
    public Equipo(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("estadio") String estadio,
            @JsonProperty("puntuacion") int puntuacion) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return puntuacion == equipo.puntuacion && Objects.equals(nombre, equipo.nombre) && Objects.equals(estadio, equipo.estadio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, estadio, puntuacion);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", estadio='" + estadio + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
