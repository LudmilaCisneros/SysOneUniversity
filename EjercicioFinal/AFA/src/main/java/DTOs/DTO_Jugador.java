package DTOs;

import Entities.Jugador;

public class DTO_Jugador {
    private int DTO_DNI;
    private String DTO_nombre;
    private int DTO_posicionActual;

    public DTO_Jugador(Jugador j){
        this.DTO_DNI = j.getDNI();
        this.DTO_nombre = j.getNombre();
        this.DTO_posicionActual = j.getPosicionActual();
    }

    public DTO_Jugador(int DNI, String nombre, int dto_posicionActual) {
        this.DTO_DNI = DNI;
        this.DTO_nombre = nombre;
        DTO_posicionActual = dto_posicionActual;
    }

    public int getDTO_DNI() {
        return DTO_DNI;
    }

    public void setDTO_DNI(int DNI) {
        this.DTO_DNI = DNI;
    }

    public String getDTO_nombre() {
        return DTO_nombre;
    }

    public void setDTO_nombre(String nombre) {
        this.DTO_nombre = nombre;
    }

    public int getDTO_posicionActual() {
        return DTO_posicionActual;
    }

    public void setDTO_posicionActual(int DTO_posicionActual) {
        this.DTO_posicionActual = DTO_posicionActual;
    }
}
