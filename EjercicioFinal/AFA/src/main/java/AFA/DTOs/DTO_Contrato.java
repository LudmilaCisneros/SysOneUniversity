package AFA.DTOs;

import AFA.Entities.Contrato;

import java.time.LocalDate;

public class DTO_Contrato {
    private int idContrato; //PK
    private int dniJugador; //FK
    private LocalDate fechaIn;
    private LocalDate fechaFin;
    private int posicion;
    private String nombreClub;

    public DTO_Contrato(Contrato contrato) {
        this.idContrato = contrato.getIdContrato();
        this.fechaIn = contrato.getFechaIn();
        this.fechaFin = contrato.getFechaFin();
        this.posicion = contrato.getPosicion();
        this.dniJugador = contrato.getJugador().getDniJugador();
        this.nombreClub = contrato.getNombreClub();
    }

    public DTO_Contrato(int idContrato, int dniJugador, LocalDate fInicial, LocalDate fFinal, int posicion, String nombreClub){
        this.idContrato = idContrato;
        this.dniJugador = dniJugador;
        this.fechaIn = fInicial;
        this.fechaFin = fFinal;
        this.posicion = posicion;
        this.nombreClub = nombreClub;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int DTO_idContrato) {
        this.idContrato = DTO_idContrato;
    }

    public int getDniJugador() {
        return dniJugador;
    }

    public void setDTO_dniJugador(int DTO_dniJugador) {
        this.dniJugador = DTO_dniJugador;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate DTO_fechaIn) {
        this.fechaIn = DTO_fechaIn;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate DTO_fechaFin) {
        this.fechaFin = DTO_fechaFin;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int DTO_posicion) {
        this.posicion = DTO_posicion;
    }

    public void setDniJugador(int dniJugador) {
        this.dniJugador = dniJugador;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }
}
