import java.time.LocalDate;

public class Dts {
    private int idDt;
    private String clubDirigido;
    private String nombre;


    public Dts(int idDt, String clubDirigido, String nombre) {
        this.idDt = idDt;
        this.clubDirigido = clubDirigido;
        this.nombre = nombre;
    }

    public String getClubDirigido() {
        return clubDirigido;
    }

    public int getIdDt() {
        return idDt;
    }

    public void setIdDt(int idDt) {
        this.idDt = idDt;
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