package AFA.DTOs;

public class DTO_Dt {

    private int id_dt;
    private String nombre;
    private int cuitEquipo;

    public DTO_Dt() { }

    public int getId_dt() {
        return id_dt;
    }

    public void setId_dt(int id_dt) {
        this.id_dt = id_dt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuitEquipo() {
        return cuitEquipo;
    }

    public void setCuitEquipo(int cuitEquipo) {
        this.cuitEquipo = cuitEquipo;
    }
}
