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

    @ManyToOne//manytomany
    @JoinColumn(name = "dni_jugador", referencedColumnName = "cuit_equipo", insertable = false, updatable = false)
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contrato> listaContratos;

    public Jugador() { }

    public Jugador(int DNI, String nombre, int posicionActual) {
        this.dniJugador = DNI;
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.listaContratos = new ArrayList<>();
    }

    public Jugador(DTO_Jugador jDTO) {
        this.dniJugador = jDTO.getDNI();
        this.nombre = jDTO.getNombre();
        this.posicionActual = jDTO.getPosicionActual();
        this.listaContratos = null;
    }

    /** Primero verifica que no exista el contrato en el jugador, si no existe lo agrega a la lista de contratos
     * @param contrato
     * @return (true) si lo agregó, (false) si no.
     */
    public boolean agregarContrato(Contrato contrato){
        for (Contrato con:this.getListaContratos()) {
            if(con.equals(contrato)){
                System.out.println("El jugador " + this.getNombre() + "posee un contrato duplicado.");
                return false;
            }
        }
        this.getListaContratos().add(contrato);
        return true;
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
