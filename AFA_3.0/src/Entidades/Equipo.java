package Entidades;
import DTOs.DTO_Equipo;

import java.util.ArrayList;
import java.util.List;

public class Equipo{
    private int CUIT;// PK
    private String nombre;
    private Dt dt;
    private List<Jugador> listaJugadores;

    public Equipo(int CUIT, String nombre, Dt dt) {
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.dt = dt;
        this.listaJugadores = new ArrayList<>();
    }

    public Equipo(DTO_Equipo eqDto){
        this.CUIT = eqDto.getDTO_CUIT();
        this.nombre = eqDto.getDTO_nombre();
        this.dt = new Dt(eqDto.getDTO_dt());
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public String dibujarNombre() {
        StringBuilder sb = new StringBuilder();
        sb.append("**************");
        sb.append("*").append(nombre).append("*");
        sb.append("**************");
        return sb.toString();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dt getDt() {
        return dt;
    }

    public void setDt(Dt dt) {
        this.dt = dt;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public String getNombre() {
        return nombre;
    }
}