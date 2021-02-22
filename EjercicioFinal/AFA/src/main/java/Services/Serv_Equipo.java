package Services;

import DTOs.DTO_Equipo;
import Entities.*;
import Repositories.Repo_Equipo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Serv_Equipo implements IServ_Equipo{

    @Autowired//inyeccion de dependencia
    Repo_Equipo repoEquipo;

    @Autowired
    Serv_Jugador servJugador;

    @Override
    public List<DTO_Equipo> obtenerEquipos(){
        return convertirEquiposADTO((List<Equipo>) repoEquipo.findAll());
    }
    @Override
    public DTO_Equipo obtenerEquipo(int cuitEquipo) {
        return convertirEquipoADTO(repoEquipo.findById(cuitEquipo).get());
    }

    @Override
    public void insertarEquipo(DTO_Equipo dtoEquipo) {
        repoEquipo.save(convertirDTOaEquipo(dtoEquipo));
    }

    @Override
    public void modificarEquipo(int cuitEquipo, DTO_Equipo dtoEquipo) {
        Equipo equipo = convertirDTOaEquipo(dtoEquipo);
        equipo.setCUIT(cuitEquipo);
        repoEquipo.save(equipo);
    }

    @Override
    public void eliminarEquipo(int cuitEquipo) {
        repoEquipo.deleteById(cuitEquipo);
    }

    /** Convierte un Equipo a DTO_Equipo
     * @param eq
     * @return eqDTO
     */
    public static DTO_Equipo convertirEquipoADTO(Equipo eq) {
        return new DTO_Equipo(eq);
    }

    /** Convierte un DTO a Equipo
     * @param eqDto
     * @return eqDTO
     */
    public static Equipo convertirDTOaEquipo(DTO_Equipo eqDto) {
        return new Equipo(eqDto);
    }

    /** Convierte de DTO a Equipos
     * @param list
     * @return
     */
    public List<Equipo> convertirDTOAEquipos(List<DTO_Equipo> list){
        List<Equipo> listEq = new ArrayList<>();
        for (DTO_Equipo dto_equipo : list) {
            listEq.add(convertirDTOaEquipo(dto_equipo));
        }
        return listEq;
    }

    /** Convierte de equipos a DTO
     * @param list
     * @return
     */
    public List<DTO_Equipo> convertirEquiposADTO(List<Equipo> list){
        List<DTO_Equipo> listDTOEq = new ArrayList<>();
        for (Equipo equipo : list) {
            listDTOEq.add(convertirEquipoADTO(equipo));
        }
        return listDTOEq;
    }

    /** Muestra todos los equipos
     * @param listaEq
     */
    public  void printTodosLosEquipos(List<Equipo> listaEq){
        for (Equipo equipo : listaEq) {
            equipoPrint(equipo);
        }
    }

    /** Muestra un equipo
     * @param equipo
     */
    public  void equipoPrint(Equipo equipo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(equipo.getNombre()).append("\n");
        sb.append("Cuit: ").append(equipo.getCUIT()).append("\n");
        sb.append("Dt: ").append(equipo.getDt().getNombre()).append(" ");

        System.out.println(sb.toString());
    }

    //INFORMES
    /**
     * Recorre la lista de jugadores del equipo verificando la existencia de un contrato vigente en la fecha indicada
     *
     * @param equipo
     * @param fecha
     */
    public void jugadoresPorFecha(Equipo equipo, LocalDate fecha) {
        int contador = 0;
        List<Jugador> listaParaOrdenar = new ArrayList<>();

        System.out.println(equipo.dibujarNombre());

        for (Jugador j : equipo.getListaJugadores()) {
            if (servJugador.laFechaExisteDentroDeLosContratos(j,fecha, equipo)) {
                listaParaOrdenar.add(j);
            }
        }
        ordenarJugadoresYPrint(listaParaOrdenar);
    }
    /** Ordena la lista alfabéticamente y printea
     * @param listaAux
     */
    public void ordenarJugadoresYPrint(List<Jugador> listaAux){
        Collections.sort(listaAux);

        for (Jugador j: listaAux){
            servJugador.printJugador(j);
        }
    }


}