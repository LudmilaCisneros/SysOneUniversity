package AFA.DTOs;

import AFA.Entities.Contrato;

import java.time.LocalDate;


public class DTO_Contrato {
    private int idContrato; //PK
    private int cuitEquipo; //FK
    private int dniJugador; //FK
    private LocalDate fechaIn;
    private LocalDate fechaFin;
    private int posicion;

    public DTO_Contrato(Contrato contrato) {
        this.idContrato = contrato.getIdContrato();
        this.fechaIn = contrato.getFechaIn();
        this.fechaFin = contrato.getFechaFin();
        this.posicion = contrato.getPosicion();
    }

    public DTO_Contrato(int idContrato, int dniJugador, int cuitEquipo, LocalDate fInicial, LocalDate fFinal, int posicion){
        this.idContrato = idContrato;
        this.cuitEquipo = cuitEquipo;
        this.dniJugador = dniJugador;
        this.fechaIn = fInicial;
        this.fechaFin = fFinal;
        this.posicion = posicion;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int DTO_idContrato) {
        this.idContrato = DTO_idContrato;
    }

    public int getCuitEquipo() {
        return cuitEquipo;
    }

    public void setCuitEquipo(int DTO_cuitEquipo) {
        this.cuitEquipo = DTO_cuitEquipo;
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
}
