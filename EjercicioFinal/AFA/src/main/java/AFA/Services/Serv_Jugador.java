package AFA.Services;

import AFA.DTOs.DTO_Equipo;
import AFA.DTOs.DTO_Jugador;
import AFA.Entities.Equipo;
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

    @Override
    public List<DTO_Jugador> obtenerJugadores(){
        return convertirJugadoresADTO((List<Jugador>) repoJugador.findAll());
    }
    /*public List<DTO_Equipo> obtenerEquipos(){
        return convertirEquiposADTO((List<Equipo>) repoEquipo.findAll());
    }*/
    @Override
    public DTO_Jugador obtenerJugador(int dniJugador) {
        return convertirJugadorADTO(repoJugador.findById(dniJugador).get());
    }

    @Override
    public void insertarJugador(DTO_Jugador dtoJugador) {
        repoJugador.save(convertirDTOAJugador(dtoJugador));
    }

    @Override
    public void modificarJugador(int dniJugador, DTO_Jugador dtoJugador) {
        Jugador jugador = convertirDTOAJugador(dtoJugador);
        jugador.setDniJugador(dniJugador);
        repoJugador.save(jugador);
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
        return new DTO_Jugador(jugador);
    }


    /** Convierte un DTO a jugador
     * @param jDTO
     * @return
     */
    public Jugador convertirDTOAJugador(DTO_Jugador jDTO) {
        return new Jugador(jDTO);
    }

}
