import java.time.LocalDate;

public class Dts extends Persona {
    private String clubDirigido;
    private LocalDate fechaInicialDireccionEquipo;
    private LocalDate fechaFinalDireccionEquipo;

    public Dts(String nombre, Direccion direccion, int telefono, int DNI, String clubDirigido, LocalDate fechaInicialDireccionEquipo, LocalDate fechaFinalDireccionEquipo) {
        super(nombre, direccion, telefono, DNI);
        this.clubDirigido = clubDirigido;
        this.fechaInicialDireccionEquipo = fechaInicialDireccionEquipo;
        this.fechaFinalDireccionEquipo = fechaFinalDireccionEquipo;
    }

    public String getClubDirigido() {
        return this.clubDirigido;
    }

    public LocalDate getFechaInicialDireccionEquipo() {
        return this.fechaInicialDireccionEquipo;
    }

    public LocalDate getFechaFinalDireccionEquipo() {
        return this.fechaFinalDireccionEquipo;
    }
} 