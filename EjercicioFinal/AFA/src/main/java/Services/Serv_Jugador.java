package Services;

import DTOs.DTO_Jugador;
import Entities.*;
import Repositories.Repo_Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Jugador implements IServ_Jugador{

    @Autowired
    Repo_Jugador repoJugador;

    public DTO_Jugador obtenerJugador(int dniJugador) {
        return convertirJugadorADTO(repoJugador.findById(dniJugador).get());
    }

    public void insertarJugador(DTO_Jugador dtoJugador) {
        repoJugador.save(convertirDTOAJugador(dtoJugador));
    }

    public void modificarJugador(int dniJugador, DTO_Jugador dtoJugador) {
        Jugador jugador = convertirDTOAJugador(dtoJugador);
        jugador.setDNI(dniJugador);
        repoJugador.save(jugador);
    }

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

    public DTO_Jugador convertirJugadorADTO(Jugador jugador) {
        return new DTO_Jugador(jugador);
    }

    public Jugador convertirDTOAJugador(DTO_Jugador jDTO) {
        return new Jugador(jDTO);
    }

    public void printJugadores(List<Jugador> jugadores){
        for (Jugador j: jugadores) {
            printJugador(j);
            System.out.println("\n");
        }
    }

    public void printJugador(Jugador j){
        StringBuilder sb = new StringBuilder();

        sb.append("Nombre: ").append(j.getNombre());
        sb.append("\nDni: ").append(j.getDNI());
        sb.append("\nPosicion Actual: ").append(j.getPosicionActual()).append("\n");

        System.out.println(sb.toString());
    }

    /** Indica si el jugador tiene algún contrato en la fecha pasada por param y que concuerden los cuit
     * @param f
     * @return (true) si existe un contrato en la fecha indicada
     */
    public Boolean laFechaExisteDentroDeLosContratos(Jugador jugador,LocalDate f, Equipo equipo){
        boolean flag = false;

        for (Contrato contrato:jugador.getListaContratos()) {
            if (f.compareTo(contrato.getFechaIn()) >= 0 && f.compareTo(contrato.getFechaFin()) <= 0 && equipo.getCUIT() == contrato.getCuitEquipo()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
