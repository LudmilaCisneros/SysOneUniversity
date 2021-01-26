import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Informes {

    /**Recorre la lista de jugadores del equipo verificando la existencia de un contrato den la fecha indicada
     * @param equipo
     * @param fecha
     * @return
     */
    public static void JugadoresPorFecha(Equipos equipo, LocalDate fecha){
        int contador = 0;

        for (Jugadores j:equipo.getListaJugadores()){
            if(j.laFechaExisteDentroDeLosContratos(fecha)){
                contador ++;
            }
        }
        System.out.println("Equipo " + equipo.getNombre() + " " + contador);
    }

/*
    public static void cantJugadoresPorEquipo(Equipos equipo) {
        System.out.println(equipo.getListaJugadores().size());
    }

    public static void ordenarJugadoresAlfabPorEquipo(Equipos equipo) {
        Collections.sort(equipo.getListaJugadores());
        System.out.println("-----------------------------------");
        System.out.println("Jugadores ordenados alfabéticamente: ");

        Collections.sort(equipo.getListaJugadores());
        for (Jugadores j:equipo.getListaJugadores()) {
            System.out.println(j.toString());
        }

    }

    public static void defensoresPorEquipo(Equipos equipo){
        ArrayList<Jugadores> listaAux = equipo.getListaJugadores();
        int contador = 0;
        for (int i=0;i<equipo.getListaJugadores().size();i++){
            if(listaAux.get(i).getPosicionEnCancha() > 1 && listaAux.get(i).getPosicionEnCancha() < 6){
                contador++;
            }
        }
        System.out.println(contador);
    }*/
} 