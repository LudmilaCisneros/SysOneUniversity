package Services;

import DTOs.DTO_Jugador;
import Entities.Equipo;
import Entities.Jugador;

import java.time.LocalDate;
import java.util.List;

public interface IServ_Jugador {
    DTO_Jugador obtenerJugador(int dniJugador);

    void insertarJugador(DTO_Jugador dtoJugador);

    void modificarJugador(int dniJugador, DTO_Jugador dtoJugador);

    void eliminarJugador(int dniJugador);

    List<Jugador> convertirJugadoresDTOaJugadores(List<DTO_Jugador> listaDTO);

    DTO_Jugador convertirJugadorADTO(Jugador jugador);

    Jugador convertirDTOAJugador(DTO_Jugador jDTO);

    void printJugador(Jugador j);

    Boolean laFechaExisteDentroDeLosContratos(Jugador jugador, LocalDate f, Equipo equipo);
}
