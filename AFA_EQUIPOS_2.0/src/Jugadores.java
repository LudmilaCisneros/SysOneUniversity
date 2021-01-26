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

    /** Ordena alfabeticamente
     * @param j2
     * @return int
     */
    public int compareTo(Jugadores j2) {
        return this.getNombre().compareTo(j2.getNombre());
    }

    /** Primero verifica que no exista el contrato en el jugador, si no existe lo agrega a la lista de contratos
     * @param contrato
     * @return (true) si lo agregó, (false) si no.
     */
    public boolean agregarContrato(Contrato contrato){
        for (Contrato con:this.getListaContratos()) {
            if(con.equals(contrato)){
                System.out.println("El jugador " + this.getNombre() + "posee un contrato duplicado.");
                return false;
            }
        }
        this.listaContratos.add(contrato);
        return true;
    }

    /** Indica si el jugador tiene algún contrato en la fecha pasada por param y que concuerden los cuit
     * @param f
     * @return (true) si existe un contrato en la fecha indicada
     */
    public Boolean laFechaExisteDentroDeLosContratos(LocalDate f, Equipos equipo){
        boolean flag = false;

        for (Contrato contrato:this.getListaContratos()) {
            if (f.compareTo(contrato.getFechaIn()) >= 0 && f.compareTo(contrato.getFechaFin()) <= 0 && equipo.getCUIT() == contrato.getCuitEquipo()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Muestra el jugador
     */
    public void printJugador(){
        StringBuilder sb = new StringBuilder();

        sb.append("Nombre: ").append(this.getNombre());
        sb.append("\nDni: ").append(this.getDNI()).append("\n");

        System.out.println(sb.toString());
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

