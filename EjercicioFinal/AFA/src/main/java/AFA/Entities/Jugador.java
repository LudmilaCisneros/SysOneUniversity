package AFA.Entities;
import AFA.DTOs.DTO_Jugador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @Column(name = "dni_jugador",nullable = false)
    private int dniJugador;// PK
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "posicion_actual",nullable = false)
    private int posicionActual;

    @ManyToOne
    @JoinColumn(name = "cuit_equipo")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contrato> listaContratos;

    public Jugador() { }

    public Jugador(int DNI, String nombre, int posicionActual, Equipo equipo) {
        this.dniJugador = DNI;
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.equipo = equipo;
        this.listaContratos = new ArrayList<>();
    }

    public Jugador(DTO_Jugador jDTO) {
        this.dniJugador = jDTO.getDNI();
        this.nombre = jDTO.getNombre();
        this.posicionActual = jDTO.getPosicionActual();
        this.equipo.setCUIT(jDTO.getCuitEquipo());
    }

    public int getDniJugador() {
        return dniJugador;
    }

    public void setDniJugador(int dniJugador) {
        this.dniJugador = dniJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public List<Contrato> getListaContratos() {
        return listaContratos;
    }

    public void setListaContratos(List<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}
