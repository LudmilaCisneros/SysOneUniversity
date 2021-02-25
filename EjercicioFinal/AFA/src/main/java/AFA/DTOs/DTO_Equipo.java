package AFA.DTOs;

import AFA.Entities.Dt;
import AFA.Entities.Equipo;

public class DTO_Equipo {
    private int CUIT;
    private String nombre;
    private Dt dt;

    public DTO_Equipo(Equipo equipo) {
        this.CUIT = equipo.getCUIT();
        this.nombre = equipo.getNombre();
        this.dt = equipo.getDt();
    }

    public DTO_Equipo(int CUIT, String nombre, Dt dt){
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.dt = dt;
    }

    public DTO_Equipo() { }

    public Dt getDt() {
        return dt;
    }

    public void setDt(Dt dt) {
        this.dt = dt;
    }

    public int getCUIT() {
        return this.CUIT;
    }

    public void setCUIT(int DTO_CUIT) {
        this.CUIT = DTO_CUIT;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String DTO_nombre) {
        this.nombre = DTO_nombre;
    }

}
