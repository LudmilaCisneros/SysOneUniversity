package AFA.DTOs;

public class DTO_Equipo {
    private int CUIT;
    private String nombre;
    private int idDt;

    public DTO_Equipo(int CUIT, String nombre, int idDt){
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.idDt = idDt;
    }

    public DTO_Equipo() { }

    public int getIdDt() {
        return idDt;
    }

    public void setIdDt(int idDt) {
        this.idDt = idDt;
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
