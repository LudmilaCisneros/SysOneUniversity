package Services;

import DTOs.DTO_Jugador;
import Entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Serv_Jugador{

    /** Convierte una lista de DTO jugadores a jugadores
     * @param listaDTO
     * @return
     */
    private List<Jugador> convertirJugadoresDTOaJugadores(List<DTO_Jugador> listaDTO){
        List<Jugador> listaJ = new ArrayList<>();

        for (int i=0;i<listaDTO.size();i++){
            listaJ.add(convertirDTOAJugador(listaDTO.get(i)));
        }

        return listaJ;
    }

    /** Convierte un jugador a DTO jugador
     * @param jugador
     * @return
     */
    public static DTO_Jugador convertirJugadorADTO(Jugador jugador) {
        return new DTO_Jugador(jugador);
    }


    /** Convierte un DTO a jugador
     * @param jDTO
     * @return
     */
    public static Jugador convertirDTOAJugador(DTO_Jugador jDTO) {
        return new Jugador(jDTO);
    }

    public static void printJugadores(List<Jugador> jugadores){
        for (Jugador j: jugadores) {
            printJugador(j);
            System.out.println("\n");
        }
    }

    /**
     * Muestra el jugador
     */
    public static void printJugador(Jugador j){
        StringBuilder sb = new StringBuilder();

        sb.append("Nombre: ").append(j.getNombre());
        sb.append("\nDni: ").append(j.getDNI());
        sb.append("\nPosicion Actual: ").append(j.getPosicionActual()).append("\n");

        System.out.println(sb.toString());
    }

    public String construirQuery(DTO_Jugador jugador, String tipo) {
        StringBuilder sb = new StringBuilder();
        switch (tipo) {
            case "INSERT":
                sb.append("INSERT INTO jugador (dni,nombre,posicionActual) values (");
                sb.append(jugador.getDTO_DNI()).append(",");
                sb.append("'").append(jugador.getDTO_nombre()).append("',");
                sb.append("'").append(jugador.getDTO_posicionActual()).append("');");
                break;
            //case "READ":
            //break;
            //case "DELETE"
            //case "UPDATE"
        }
        return sb.toString();
    }
    /** Primero verifica que no exista el contrato en el jugador, si no existe lo agrega a la lista de contratos
     * @param contrato
     * @return (true) si lo agregó, (false) si no.
     */
    public boolean agregarContrato(Jugador jugador, Contrato contrato){
        for (Contrato con:jugador.getListaContratos()) {
            if(con.equals(contrato)){
                System.out.println("El jugador " + jugador.getNombre() + "posee un contrato duplicado.");
                return false;
            }
        }
        jugador.getListaContratos().add(contrato);
        return true;
    }

    /** Indica si el jugador tiene algún contrato en la fecha pasada por param y que concuerden los cuit
     * @param f
     * @return (true) si existe un contrato en la fecha indicada
     */
    public static Boolean laFechaExisteDentroDeLosContratos(Jugador jugador,LocalDate f, Equipo equipo){
        boolean flag = false;

        for (Contrato contrato:jugador.getListaContratos()) {
            if (f.compareTo(contrato.getFechaIn()) >= 0 && f.compareTo(contrato.getFechaFin()) <= 0 && equipo.getCUIT() == contrato.getCuitEquipo()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
