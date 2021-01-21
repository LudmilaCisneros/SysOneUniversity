import java.time.LocalDate;
import java.util.ArrayList;

public class Equipos {
    private String nombre;
    private LocalDate fechaFundacion;
    private String nombreYApellidoPresidente;
    private Direccion direccion;
    private int telefono;
    private String email;
    private LocalDate fechaInicioEnPrimera;
    private LocalDate fechaFinalEnPrimera;
    private char categoriaActual;
    private ArrayList<Jugadores> listaJugadores;
    private Dts dt;

    public Equipos(String nombre, LocalDate fechaFundacion, String nombreYApellidoPresidente, Direccion direccion, int telefono, String email, LocalDate fechaInicioEnPrimera, LocalDate fechaFinalEnPrimera, char categoriaActual, Dts dt, ArrayList<Jugadores> listaJugadores) {
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.nombreYApellidoPresidente = nombreYApellidoPresidente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaInicioEnPrimera = fechaInicioEnPrimera;
        this.fechaFinalEnPrimera = fechaFinalEnPrimera;
        this.categoriaActual = categoriaActual;
        this.dt = dt;
        this.listaJugadores = listaJugadores;
    }

    public String getNombre() {
        return this.nombre;
    }

    public LocalDate getFechaFundacion() {
        return this.fechaFundacion;
    }

    public String getNombreYApellidoPresidente() {
        return this.nombreYApellidoPresidente;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getFechaInicioEnPrimera() {
        return this.fechaInicioEnPrimera;
    }

    public LocalDate getFechaFinalEnPrimera() {
        return this.fechaFinalEnPrimera;
    }

    public char getCategoriaActual() {
        return this.categoriaActual;
    }

    public ArrayList<Jugadores> getListaJugadores() {
        return this.listaJugadores;
    }

    public Dts getDt() {
        return this.dt;
    }
}
