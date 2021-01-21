import java.time.LocalDate;

public class Jugadores extends Persona implements Comparable<Jugadores> {
    private Direccion direccion;
    private String nombreClub;
    private LocalDate desdeCuando;
    private LocalDate desdeHasta;
    private LocalDate fechaNacimiento;
    private LocalDate fechaDebut;
    private int cantPartidosJugados;
    private int goles;
    private int peso;
    private int altura;
    private int posicionEnCancha;

    public Jugadores(String nombre, int telefono, int DNI, Direccion direccion, String nombreClub, LocalDate desdeCuando, LocalDate desdeHasta, LocalDate fechaNacimiento, LocalDate fechaDebut, int cantPartidosJugados, int goles, int peso, int altura, int posicionEnCancha) {
        super(nombre, direccion, telefono, DNI);
        this.nombreClub = nombreClub;
        this.desdeCuando = desdeCuando;
        this.desdeHasta = desdeHasta;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDebut = fechaDebut;
        this.cantPartidosJugados = cantPartidosJugados;
        this.goles = goles;
        this.peso = peso;
        this.altura = altura;
        this.posicionEnCancha = posicionEnCancha;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public String getNombreClub() {
        return this.nombreClub;
    }

    public LocalDate getDesdeCuando() {
        return this.desdeCuando;
    }

    public LocalDate getDesdeHasta() {
        return this.desdeHasta;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public LocalDate getFechaDebut() {
        return this.fechaDebut;
    }

    public int getCantPartidosJugados() {
        return this.cantPartidosJugados;
    }

    public int getGoles() {
        return this.goles;
    }

    public int getPeso() {
        return this.peso;
    }

    public int getAltura() {
        return this.altura;
    }

    public int getPosicionEnCancha() {
        return this.posicionEnCancha;
    }

    public int compareTo(Jugadores j2) {
        return this.getNombre().compareTo(j2.getNombre());
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}

