package Services;

import DTOs.DTO_Equipo;
import Entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IServ_Equipo {

    List<DTO_Equipo> obtenerEquipos();

    DTO_Equipo obtenerEquipo(int cuitEquipo);

    void insertarEquipo(DTO_Equipo dtoEquipo);

    void modificarEquipo(int cuitEquipo, DTO_Equipo dtoEquipo);

    void eliminarEquipo(int cuitEquipo);

    void equipoPrint(Equipo equipo);

    void printTodosLosEquipos(List<Equipo> listaEq);

    void jugadoresPorFecha(Equipo equipo, LocalDate fecha);

    void ordenarJugadoresYPrint(List<Jugador> listaAux);

}

