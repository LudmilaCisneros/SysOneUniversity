package Services;

import DTOs.DTO_Equipo;
import Entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IServ_Equipo {

    public DTO_Equipo obtenerEquipo(int cuitEquipo);

    public void insertarEquipo(DTO_Equipo dtoEquipo);

    public void modificarEquipo(int cuitEquipo, DTO_Equipo dtoEquipo);

    public void eliminarEquipo(int cuitEquipo);

    public void equipoPrint(Equipo equipo);

    public  void printTodosLosEquipos(List<Equipo> listaEq);

    public void jugadoresPorFecha(Equipo equipo, LocalDate fecha);

    public  void ordenarJugadoresYPrint(List<Jugador> listaAux);

}

