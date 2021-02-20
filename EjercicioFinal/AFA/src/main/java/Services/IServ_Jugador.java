package Services;

import DTOs.DTO_Jugador;
import Entities.Equipo;
import Entities.Jugador;

import java.time.LocalDate;
import java.util.List;

public interface IServ_Jugador {

        public DTO_Jugador obtenerJugador(int dniJugador);

        public void insertarJugador(DTO_Jugador dtoJugador);

        public void modificarJugador(int dniJugador, DTO_Jugador dtoJugador);

        public void eliminarJugador(int dniJugador);

        public List<Jugador> convertirJugadoresDTOaJugadores(List<DTO_Jugador> listaDTO);

        public DTO_Jugador convertirJugadorADTO(Jugador jugador);

        public Jugador convertirDTOAJugador(DTO_Jugador jDTO);

        public void printJugadores(List<Jugador> jugadores);

        public void printJugador(Jugador j);

        public  Boolean laFechaExisteDentroDeLosContratos(Jugador jugador, LocalDate f, Equipo equipo);

}
