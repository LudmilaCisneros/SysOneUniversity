package AFA.Services;

import AFA.DTOs.DTO_Jugador;

import java.util.List;

public interface IServ_Jugador {

    List<DTO_Jugador> obtenerJugadores();

    DTO_Jugador obtenerJugador(int dniJugador);

    void insertarJugador(DTO_Jugador dtoJugador);

    void eliminarJugador(int dniJugador);
}
