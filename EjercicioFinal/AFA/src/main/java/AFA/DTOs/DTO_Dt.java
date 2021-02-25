package AFA.DTOs;

import AFA.Entities.Dt;

public class DTO_Dt {

    private int id_dt;
    private String clubDirigido;
    private String nombre;

    public DTO_Dt(Dt dt) {
        this.id_dt = dt.getId_dt();
        this.clubDirigido = dt.getClubDirigido();
        this.nombre = dt.getNombre();
    }

    public DTO_Dt(int id_dt, String clubDirigido, String nombre) {
        this.id_dt = id_dt;
        this.clubDirigido = clubDirigido;
        this.nombre = nombre;
    }

    public int getId_dt() {
        return id_dt;
    }

    public void setId_dt(int id_dt) {
        this.id_dt = id_dt;
    }

    public String getClubDirigido() {
        return clubDirigido;
    }

    public void setClubDirigido(String clubDirigido) {
        this.clubDirigido = clubDirigido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
