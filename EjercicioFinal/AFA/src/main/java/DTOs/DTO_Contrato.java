package DTOs;

import Entities.Contrato;

import java.time.LocalDate;


public class DTO_Contrato {
    private int DTO_idContrato; //PK
    private int DTO_cuitEquipo; //FK
    private int DTO_dniJugador; //FK
    private LocalDate DTO_fechaIn;
    private LocalDate DTO_fechaFin;
    private int DTO_posicion;

    public DTO_Contrato(Contrato contrato) {
        this.DTO_idContrato = contrato.getIdContrato();
        this.DTO_cuitEquipo = contrato.getCuitEquipo();
        this.DTO_dniJugador = contrato.getDniJugador();
        this.DTO_fechaIn = contrato.getFechaIn();
        this.DTO_fechaFin = contrato.getFechaFin();
        this.DTO_posicion = contrato.getPosicion();
    }

    public DTO_Contrato(int idContrato, int dniJugador, int cuitEquipo, LocalDate fInicial, LocalDate fFinal, int posicion){
        this.DTO_idContrato = idContrato;
        this.DTO_cuitEquipo = cuitEquipo;
        this.DTO_dniJugador = dniJugador;
        this.DTO_fechaIn = fInicial;
        this.DTO_fechaFin = fFinal;
        this.DTO_posicion = posicion;
    }

    public int getDTO_idContrato() {
        return DTO_idContrato;
    }

    public void setDTO_idContrato(int DTO_idContrato) {
        this.DTO_idContrato = DTO_idContrato;
    }

    public int getDTO_cuitEquipo() {
        return DTO_cuitEquipo;
    }

    public void setDTO_cuitEquipo(int DTO_cuitEquipo) {
        this.DTO_cuitEquipo = DTO_cuitEquipo;
    }

    public int getDTO_dniJugador() {
        return DTO_dniJugador;
    }

    public void setDTO_dniJugador(int DTO_dniJugador) {
        this.DTO_dniJugador = DTO_dniJugador;
    }

    public LocalDate getDTO_fechaIn() {
        return DTO_fechaIn;
    }

    public void setDTO_fechaIn(LocalDate DTO_fechaIn) {
        this.DTO_fechaIn = DTO_fechaIn;
    }

    public LocalDate getDTO_fechaFin() {
        return DTO_fechaFin;
    }

    public void setDTO_fechaFin(LocalDate DTO_fechaFin) {
        this.DTO_fechaFin = DTO_fechaFin;
    }

    public int getDTO_posicion() {
        return DTO_posicion;
    }

    public void setDTO_posicion(int DTO_posicion) {
        this.DTO_posicion = DTO_posicion;
    }
}
