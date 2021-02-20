package Services;

import Entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IServ_Equipo {

    public void equipoPrint(Equipo equipo);

    public  void printTodosLosEquipos(List<Equipo> listaEq);

    public void jugadoresPorFecha(Equipo equipo, LocalDate fecha);

    public  void ordenarJugadoresYPrint(List<Jugador> listaAux);

}

