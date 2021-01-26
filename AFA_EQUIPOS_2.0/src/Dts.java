import java.time.LocalDate;

public class Dts {
    private String clubDirigido;
    private String nombre;


    public Dts(String clubDirigido, String nombre) {
        this.clubDirigido = clubDirigido;
        this.nombre = nombre;
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