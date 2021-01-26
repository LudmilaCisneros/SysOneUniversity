import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipos {
    private int CUIT;// PK
    private String nombre;
    private Dts dt;
    private List<Jugadores> listaJugadores;

    public Equipos(int CUIT, String nombre, Dts dt) {
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.dt = dt;
        this.listaJugadores = new ArrayList<>();

    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public String getNombre() {
        StringBuilder sb = new StringBuilder();
        sb.append("**************");
        sb.append("*").append(nombre).append("*");
        sb.append("**************");
        return sb.toString();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dts getDt() {
        return dt;
    }

    public void setDt(Dts dt) {
        this.dt = dt;
    }

    public List<Jugadores> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugadores> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
}
