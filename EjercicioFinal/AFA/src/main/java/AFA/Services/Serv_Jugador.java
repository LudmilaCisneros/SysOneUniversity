package AFA.Services;

import AFA.DTOs.DTO_Jugador;
import AFA.Entities.Equipo;
import AFA.Repositories.Repo_Equipo;
import AFA.Repositories.Repo_Jugador;
import AFA.Entities.Jugador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Jugador implements IServ_Jugador{

    @Autowired
    Repo_Jugador repoJugador;

    @Autowired
    Repo_Equipo repoEquipo;

    @Override
    public List<DTO_Jugador> obtenerJugadores(){
        return convertirJugadoresADTO((List<Jugador>) repoJugador.findAll());
    }

    @Override
    public DTO_Jugador obtenerJugador(int dniJugador) {
        return convertirJugadorADTO(repoJugador.findById(dniJugador).get());
    }

    @Override
    public void insertarJugador(DTO_Jugador dtoJugador) {
        repoJugador.save(convertirDTOAJugador(dtoJugador));
    }

    @Override
    public void eliminarJugador(int dniJugador) {
        repoJugador.deleteById(dniJugador);
    }

    /** Convierte una lista de DTO jugadores a jugadores
     * @param listaDTO
     * @return
     */
    public List<Jugador> convertirJugadoresDTOaJugadores(List<DTO_Jugador> listaDTO){
        List<Jugador> listaJ = new ArrayList<>();

        for (int i=0;i<listaDTO.size();i++){
            listaJ.add(convertirDTOAJugador(listaDTO.get(i)));
        }

        return listaJ;
    }

    /** Convierte una lista de jugadores a dto
     * @param list
     * @return
     */
    public List<DTO_Jugador> convertirJugadoresADTO(List<Jugador> list){
        List<DTO_Jugador> listaDTO = new ArrayList<>();

        for (Jugador jugador : list) {
            listaDTO.add(convertirJugadorADTO(jugador));
        }
        return listaDTO;
    }

    /** Convierte un jugador a DTO jugador
     * @param jugador
     * @return
     */
    public DTO_Jugador convertirJugadorADTO(Jugador jugador) {
        DTO_Jugador dtoJugador = new DTO_Jugador();

        dtoJugador.setNombre(jugador.getNombre());
        dtoJugador.setDNI(jugador.getDniJugador());
        dtoJugador.setPosicionActual(jugador.getPosicionActual());
        dtoJugador.setCuitEquipo(jugador.getEquipo().getCUIT());

        return dtoJugador;
    }

    /** Convierte un DTO a jugador
     * @param jDTO
     * @return
     */
    public Jugador convertirDTOAJugador(DTO_Jugador jDTO) {
        Jugador jugador = new Jugador();
        Serv_Equipo sE = new Serv_Equipo();
        Equipo equipo;

        jugador.setDniJugador(jDTO.getDNI());
        jugador.setNombre(jDTO.getNombre());
        jugador.setPosicionActual(jDTO.getPosicionActual());

        equipo = repoEquipo.findById(jDTO.getCuitEquipo()).get();
        jugador.setEquipo(equipo);

        return jugador;
    }

}
