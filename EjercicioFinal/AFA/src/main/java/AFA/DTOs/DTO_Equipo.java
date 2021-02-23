package AFA.DTOs;

import AFA.Entities.Equipo;

public class DTO_Equipo {
    private int DTO_CUIT;// PK
    private String DTO_nombre;
    private int DTO_idDt;

    public DTO_Equipo(Equipo equipo) {
        this.DTO_CUIT = equipo.getCUIT();
        this.DTO_nombre = equipo.getNombre();
        this.DTO_idDt = equipo.getDt().getIdDt();
    }
    public DTO_Equipo(int CUIT, String nombre, int idDt){
        this.DTO_CUIT = CUIT;
        this.DTO_nombre = nombre;
        this.DTO_idDt = idDt;
    }

    public int getDTO_CUIT() {
        return DTO_CUIT;
    }

    public void setDTO_CUIT(int DTO_CUIT) {
        this.DTO_CUIT = DTO_CUIT;
    }

    public String getDTO_nombre() {
        return DTO_nombre;
    }

    public void setDTO_nombre(String DTO_nombre) {
        this.DTO_nombre = DTO_nombre;
    }

    public int getDTO_idDt() {
        return DTO_idDt;
    }

    public void setDTO_idDt(int DTO_idDt) {
        this.DTO_idDt = DTO_idDt;
    }

}
