package AFA.DTOs;

import java.time.LocalDate;

public class DTO_Contrato {
    private int idContrato;
    private LocalDate fechaIn;
    private LocalDate fechaFin;
    private int posicion;
    private String nombreClub;
    private int dni_jugador;

    public DTO_Contrato() { }

    public int getDni_jugador() {
        return dni_jugador;
    }

    public void setDni_jugador(int dni_jugador) {
        this.dni_jugador = dni_jugador;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

}
