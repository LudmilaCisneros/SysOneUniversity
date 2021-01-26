import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jugadores implements Comparable<Jugadores> {
    private int DNI;// PK
    private String nombre;
    private int posicionActual;
    private List<Contrato> listaContratos;

    public Jugadores(int DNI, String nombre, int posicionActual) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.listaContratos = new ArrayList<>();
    }

    public int compareTo(Jugadores j2) {
        return this.getNombre().compareTo(j2.getNombre());
    }

    public void agregarContrato(Contrato contrato){
        this.listaContratos.add(contrato);
    }

    /** Indica si el jugador tiene algún contrato en la fecha pasada por param
     * @param fecha
     * @return
     */
    public boolean laFechaExisteDentroDeLosContratos(LocalDate fecha){ //REVISAR EL METODO NO COMPARA CORRECTAMENTE LAS FECHAS
        for (Contrato con:this.getListaContratos()) {
            //if(fecha.after(con.getFechaIn()) && fecha.before(con.getFechaFin())){
            if(fecha.compareTo(con.getFechaIn()) >= 0 && fecha.compareTo(con.getFechaFin())<= 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getNombre();
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
}

