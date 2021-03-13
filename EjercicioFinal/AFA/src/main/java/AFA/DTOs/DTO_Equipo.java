package AFA.DTOs;

public class DTO_Equipo {
    private int CUIT;
    private String nombre;

    public DTO_Equipo() { }

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
