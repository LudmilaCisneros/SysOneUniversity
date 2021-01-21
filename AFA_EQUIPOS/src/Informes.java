import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Informes {

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
    }
} 