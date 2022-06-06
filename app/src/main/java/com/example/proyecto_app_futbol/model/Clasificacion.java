package com.example.proyecto_app_futbol.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Clasificacion {
    private int posicion;
    private String nombre;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesFavor;
    private int golesContra;

    @JsonCreator
    public Clasificacion(
            @JsonProperty("posicion") int posicion,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("partidosJugados") int partidosJugados,
            @JsonProperty("partidosGanados") int partidosGanados,
            @JsonProperty("partidosEmpatados") int partidosEmpatados,
            @JsonProperty("partidosPerdidos") int partidosPerdidos,
            @JsonProperty("golesFavor") int golesFavor,
            @JsonProperty("golesContra") int golesContra) {
        this.posicion = posicion;
        this.nombre = nombre;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosEmpatados = partidosEmpatados;
        this.partidosPerdidos = partidosPerdidos;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clasificacion that = (Clasificacion) o;
        return posicion == that.posicion && partidosJugados == that.partidosJugados && partidosGanados == that.partidosGanados && partidosEmpatados == that.partidosEmpatados && partidosPerdidos == that.partidosPerdidos && golesFavor == that.golesFavor && golesContra == that.golesContra && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicion, nombre, partidosJugados, partidosGanados, partidosEmpatados, partidosPerdidos, golesFavor, golesContra);
    }

    @Override
    public String toString() {
        return "Clasificacion{" +
                "posicion=" + posicion +
                ", nombreEquipo='" + nombre + '\'' +
                ", partidosJugados=" + partidosJugados +
                ", partidosGanados=" + partidosGanados +
                ", partidosEmpatados=" + partidosEmpatados +
                ", partidosPerdidos=" + partidosPerdidos +
                ", golesFavor=" + golesFavor +
                ", golesContra=" + golesContra +
                '}';
    }
}
