import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Informes {

    /**Recorre la lista de jugadores del equipo verificando la existencia de un contrato vigente en la fecha indicada
     * @param equipo
     * @param fecha
     */
    public static void jugadoresPorFecha(Equipos equipo, LocalDate fecha){
        int contador = 0;
        List<Jugadores> listaParaOrdenar = new ArrayList<>();

        System.out.println(equipo.getNombre());

        for (Jugadores j:equipo.getListaJugadores()){
            if(j.laFechaExisteDentroDeLosContratos(fecha,equipo)){
                listaParaOrdenar.add(j);
            }
        }
        ordenarJugadoresYPrint(listaParaOrdenar);
    }


    /** Ordena la lista alfabéticamente y printea
     * @param listaAux
     */
    private static void ordenarJugadoresYPrint(List<Jugadores> listaAux){
        Collections.sort(listaAux);

        for (Jugadores j: listaAux){
            j.printJugador();
        }
    }
} 