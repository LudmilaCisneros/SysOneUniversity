package Entidades;
import DTOs.DTO_Jugador;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Comparable<Jugador> {
    private int DNI;// PK
    private String nombre;
    private int posicionActual;
    private List<Contrato> listaContratos;

    public Jugador(int DNI, String nombre, int posicionActual) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.listaContratos = new ArrayList<>();
    }

    public Jugador(DTO_Jugador jDTO) {
        this.DNI = jDTO.getDTO_DNI();
        this.nombre = jDTO.getDTO_nombre();
        this.posicionActual = jDTO.getDTO_posicionActual();
        this.listaContratos = null;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public List<Contrato> getListaContratos() {
        return listaContratos;
    }

    public void setListaContratos(List<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }


    /* Ordena alfabeticamente
     * @param j2
     * @return int
     */
    @Override
    public int compareTo(Jugador j2) {
        return this.getNombre().compareTo(j2.getNombre());
    }

}

