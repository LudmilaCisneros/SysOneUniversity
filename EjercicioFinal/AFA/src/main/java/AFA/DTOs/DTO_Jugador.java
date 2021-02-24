package AFA.DTOs;

import AFA.Entities.Jugador;

public class DTO_Jugador {
    private int DNI;
    private String nombre;
    private int posicionActual;
    private int cuitEquipo;

    public DTO_Jugador(Jugador j){
        this.DNI = j.getDniJugador();
        this.nombre = j.getNombre();
        this.posicionActual = j.getPosicionActual();
        this.cuitEquipo = j.getEquipo().getCUIT();
    }

    public DTO_Jugador(int DNI, String nombre, int dto_posicionActual , int cuit_equipo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.posicionActual = dto_posicionActual;
        this.cuitEquipo = cuit_equipo;
    }

    public int getCuitEquipo() {
        return cuitEquipo;
    }

    public void setCuitEquipo(int cuitEquipo) {
        this.cuitEquipo = cuitEquipo;
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

    public void setPosicionActual(int DTO_posicionActual) {
        this.posicionActual = DTO_posicionActual;
    }
}
