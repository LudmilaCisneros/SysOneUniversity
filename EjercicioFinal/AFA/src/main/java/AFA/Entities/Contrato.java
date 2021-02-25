package AFA.Entities;

import AFA.DTOs.DTO_Contrato;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contratos")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_contrato")
    private int idContrato; //PK
    @Column(name = "fecha_inicial")
    private LocalDate fechaIn;
    @Column(name = "fecha_final")
    private LocalDate fechaFin;
    @Column(name = "posicion")
    private int posicion;
    @Column(name = "nombre_club")
    private String nombreClub;

    @ManyToOne
    @JoinColumn(name = "dni_jugador", referencedColumnName = "dni_jugador",nullable = false)
    private Jugador jugador;

    public Contrato(){  };

    public Contrato(int idContrato, String nombreClub, Jugador jugador, LocalDate fechaIn, LocalDate fechaFin, int posicion) {
        this.idContrato = idContrato;
        this.fechaIn = fechaIn;
        this.nombreClub = nombreClub;
        this.fechaFin = fechaFin;
        this.posicion = posicion;
        this.jugador = jugador;
    }

    public  Contrato(DTO_Contrato contratoDTO){
        this.idContrato = contratoDTO.getIdContrato();
        this.fechaIn = contratoDTO.getFechaIn();
        this.fechaFin = contratoDTO.getFechaFin();
        this.posicion = contratoDTO.getPosicion();
        this.jugador = contratoDTO.getJugador();
        this.nombreClub = contratoDTO.getNombreClub();
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

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}