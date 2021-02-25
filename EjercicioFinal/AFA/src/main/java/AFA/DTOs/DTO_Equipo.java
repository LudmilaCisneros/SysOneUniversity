package AFA.DTOs;

import AFA.Entities.Dt;
import AFA.Entities.Equipo;

public class DTO_Equipo {
    private int CUIT;
    private String nombre;
    private int idDt;
    //private Dt dt;

    public DTO_Equipo(Equipo equipo) {
        this.CUIT = equipo.getCUIT();
        this.nombre = equipo.getNombre();
        this.idDt = equipo.getDt().getIdDt();
        //this.dt = equipo.getDt();
    }
    public DTO_Equipo(int CUIT, String nombre,int idDt){
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.idDt = idDt;
        //this.dt = dt;
    }
/*
    public Dt getDt() {
        return dt;
    }

    public void setDt(Dt dt) {
        this.dt = dt;
    }
*/
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

    public int getIdDt() {
        return this.idDt;
    }

    public void setIdDt(int DTO_idDt) {
        this.idDt = DTO_idDt;
    }

}
