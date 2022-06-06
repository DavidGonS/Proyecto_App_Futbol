package com.example.proyecto_app_futbol.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Jugador {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int dorsal;
    private String nacionalidad;
    private String posicion;
    private int valorMercado;

    @JsonCreator
    public Jugador(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("apellido") String apellido,
            @JsonProperty("fechaNacimiento") String fechaNacimiento,
            @JsonProperty("dorsal") int dorsal,
            @JsonProperty("nacionalidad") String nacionalidad,
            @JsonProperty("posicion") String posicion,
            @JsonProperty("valorMercado") int valorMercado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(int valorMercado) {
        this.valorMercado = valorMercado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return dorsal == jugador.dorsal && valorMercado == jugador.valorMercado && Objects.equals(nombre, jugador.nombre) && Objects.equals(apellido, jugador.apellido) && Objects.equals(fechaNacimiento, jugador.fechaNacimiento) && Objects.equals(nacionalidad, jugador.nacionalidad) && Objects.equals(posicion, jugador.posicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", dorsal=" + dorsal +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", posicion='" + posicion + '\'' +
                ", valorMercado=" + valorMercado +
                '}';
    }
}
