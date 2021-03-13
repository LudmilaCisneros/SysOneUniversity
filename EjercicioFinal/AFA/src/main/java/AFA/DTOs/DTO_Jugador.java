package AFA.DTOs;

public class DTO_Jugador {
    private int DNI;
    private String nombre;
    private int posicionActual;
    private int cuitEquipo;

    public DTO_Jugador() { }

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
