package Entities;

import DTOs.DTO_Contrato;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contratos")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idContrato")
    private int idContrato; //PK

    @Column(name = "cuitEquipo")
    private int cuitEquipo; //FK

    @Column(name = "dniJugador")
    private int dniJugador; //FK

    @Column(name = "fechaInicial")
    private LocalDate fechaIn;

    @Column(name = "fechaFinal")
    private LocalDate fechaFin;

    @Column(name = "posicion")
    private int posicion;

    public Contrato(){  };

    public Contrato(int idContrato, int cuitEquipo, int dniJugador, LocalDate fechaIn, LocalDate fechaFin, int posicion) {
        this.idContrato = idContrato;
        this.cuitEquipo = cuitEquipo;
        this.dniJugador = dniJugador;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
        this.posicion = posicion;
    }

    public  Contrato(DTO_Contrato contratoDTO){
        this.idContrato = contratoDTO.getDTO_idContrato();
        this.cuitEquipo = contratoDTO.getDTO_cuitEquipo();
        this.dniJugador = contratoDTO.getDTO_dniJugador();
        this.fechaIn = contratoDTO.getDTO_fechaIn();
        this.fechaFin = contratoDTO.getDTO_fechaFin();
        this.posicion = contratoDTO.getDTO_posicion();
    }

    public int getIdContrato() {
        return idContrato;
    }

    @Override
    public boolean equals(Object o) {
        Contrato aux = (Contrato) o;
        return this.cuitEquipo == aux.cuitEquipo && this.dniJugador == aux.dniJugador && this.getFechaIn() == aux.getFechaIn() && this.getFechaFin() == aux.getFechaFin();
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getCuitEquipo() {
        return cuitEquipo;
    }

    public void setCuitEquipo(int cuitEquipo) {
        this.cuitEquipo = cuitEquipo;
    }

    public int getDniJugador() {
        return dniJugador;
    }

    public void setDniJugador(int dniJugador) {
        this.dniJugador = dniJugador;
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
}