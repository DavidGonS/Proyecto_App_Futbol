package com.example.proyecto_app_futbol.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class JugadorList {
    private String idJugador;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int dorsal;
    private String nacionalidad;
    private String posicion;
    private int valorMercado;
    private String idEquipo;

    @JsonCreator
    public JugadorList(
            @JsonProperty("idJugador") String idJugador,
            @JsonProperty("nombre")String nombre,
            @JsonProperty("apellido")String apellido,
            @JsonProperty("fechaNacimiento")String fechaNacimiento,
            @JsonProperty("dorsal")int dorsal,
            @JsonProperty("nacionalidad")String nacionalidad,
            @JsonProperty("posicion")String posicion,
            @JsonProperty("valorMercado")int valorMercado,
            @JsonProperty("idEquipo")String idEquipo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
        this.idEquipo = idEquipo;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
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

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorList that = (JugadorList) o;
        return dorsal == that.dorsal && valorMercado == that.valorMercado && Objects.equals(idJugador, that.idJugador) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(nacionalidad, that.nacionalidad) && Objects.equals(posicion, that.posicion) && Objects.equals(idEquipo, that.idEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugador, nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado, idEquipo);
    }

    @Override
    public String toString() {
        return "JugadorList{" +
                "idJugador='" + idJugador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", dorsal=" + dorsal +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", posicion='" + posicion + '\'' +
                ", valorMercado=" + valorMercado +
                ", idEquipo='" + idEquipo + '\'' +
                '}';
    }
}
