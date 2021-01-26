import java.time.LocalDate;

public class Contrato {
    private int idContrato; //PK
    private int cuitEquipo; //FK
    private int dniJugador; //FK
    private LocalDate fechaIn;
    private LocalDate fechaFin;
    private int posicion;

    public Contrato(int idContrato, int cuitEquipo, int dniJugador, LocalDate fechaIn, LocalDate fechaFin, int posicion) {
        this.idContrato = idContrato;
        this.cuitEquipo = cuitEquipo;
        this.dniJugador = dniJugador;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
        this.posicion = posicion;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getCuitEquipo() {
        return cuitEquipo;
    }

    public void setCuitEquipo(int cuitEquipo) {
        this.cuitEquipo = cuitEquipo;
    }

    public int getDniJugador() {
        return dniJugador;
    }

    public void setDniJugador(int dniJugador) {
        this.dniJugador = dniJugador;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
