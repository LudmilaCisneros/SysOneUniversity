package AFA.DTOs;

import AFA.Entities.Contrato;
import AFA.Entities.Jugador;

import java.time.LocalDate;

public class DTO_Contrato {
    private int idContrato;
    private Jugador jugador;
    private LocalDate fechaIn;
    private LocalDate fechaFin;
    private int posicion;
    private String nombreClub;

    public DTO_Contrato(Contrato contrato) {
        this.idContrato = contrato.getIdContrato();
        this.fechaIn = contrato.getFechaIn();
        this.fechaFin = contrato.getFechaFin();
        this.posicion = contrato.getPosicion();
        this.jugador = contrato.getJugador();
        this.nombreClub = contrato.getNombreClub();
    }

    public DTO_Contrato(int idContrato, int dniJugador, LocalDate fInicial, LocalDate fFinal, int posicion, String nombreClub){
        this.idContrato = idContrato;
        this.jugador = getJugador();
        this.fechaIn = fInicial;
        this.fechaFin = fFinal;
        this.posicion = posicion;
        this.nombreClub = nombreClub;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
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
