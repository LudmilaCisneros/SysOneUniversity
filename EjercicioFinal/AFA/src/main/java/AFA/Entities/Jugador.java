package AFA.Entities;
import AFA.DTOs.DTO_Jugador;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador implements Comparable<Jugador> {

    @Id
    @Column(name = "dniJugador",nullable = false)
    private int DNI;// PK

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "posicionActual",nullable = false)
    private int posicionActual;

    @OneToMany(mappedBy = "jugador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contrato> listaContratos;

    @ManyToOne
    private Equipo equipo;

    public Jugador() { }

    public Jugador(int DNI, String nombre, int posicionActual) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.listaContratos = new ArrayList<>();
    }

    public Jugador(DTO_Jugador jDTO) {
        this.DNI = jDTO.getDTO_DNI();
        this.nombre = jDTO.getDTO_nombre();
        this.posicionActual = jDTO.getDTO_posicionActual();
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

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
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


    /* Ordena alfabeticamente
     * @param j2
     * @return int
     */
    @Override
    public int compareTo(Jugador j2) {
        return this.getNombre().compareTo(j2.getNombre());
    }

}
