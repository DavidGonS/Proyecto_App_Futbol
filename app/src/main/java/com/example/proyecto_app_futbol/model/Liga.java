package com.example.proyecto_app_futbol.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Liga {
    private String idLiga;
    private String nombre;
    private String pais;

    @JsonCreator
    public Liga(
            @JsonProperty("idLiga") String idLiga,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("pais") String pais) {
        this.idLiga = idLiga;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(String idLiga) {
        this.idLiga = idLiga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liga liga = (Liga) o;
        return Objects.equals(idLiga, liga.idLiga) && Objects.equals(nombre, liga.nombre) && Objects.equals(pais, liga.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLiga, nombre, pais);
    }

    @Override
    public String toString() {
        return "Liga{" +
                "idLiga='" + idLiga + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
