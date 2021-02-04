package CapaServicios;
import DAOs.DAO_Equipo;
import DTOs.DTO_Equipo;
import Entidades.Contrato;
import Entidades.Equipo;
import Entidades.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Serv_Equipo {

    public void insert(DTO_Equipo obj) {
        DAO_Equipo consulta = new DAO_Equipo();

        String query = construirQuery(obj, "INSERT");

        if(consulta.hacerInsert(obj, query))
            System.out.println("El insert de " + obj.getDTO_nombre() + " fue exitoso.");
    }

    public void read() {
        DAO_Equipo consulta = new DAO_Equipo();
        List<Equipo> listaEq = new ArrayList<>();
        List<DTO_Equipo> equiposDTO = new ArrayList<>();

        equiposDTO = consulta.hacerSelect("SELECT * from equipo");
        listaEq = convertirDTOAEquipos(equiposDTO);
        printTodosLosEquipos(listaEq);
    }
    /** Agrega un contrato al jugador indicado por parametro
     * @param jugador
     * @param contrato
     */
    public static void agregarContratoAlJugador(Jugador jugador, Contrato contrato) {
        jugador.getListaContratos().add(contrato);
    }

    /** Convierte un Equipo a DTO_Equipo
     * @param eq
     * @return eqDTO
     */
    public static DTO_Equipo convertirEquipoADTO(Equipo eq) {
        DTO_Equipo eqDTO = new DTO_Equipo(eq);
        return eqDTO;
    }

    /** Convierte un DTO a Equipo
     * @param eqDto
     * @return eqDTO
     */
    public static Equipo convertirDTOaEquipo(DTO_Equipo eqDto) {
        Equipo eq = new Equipo(eqDto);
        return eq;
    }

    /** Convierte de DTO a Equipos
     * @param list
     * @return
     */
    public  static List<Equipo> convertirDTOAEquipos(List<DTO_Equipo> list){
        List<Equipo> listEq = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            listEq.add(convertirDTOaEquipo(list.get(i)));
        }
        return listEq;
    }

    /** Muestra todos los equipos
     * @param listaEq
     */
    public static void printTodosLosEquipos(List<Equipo> listaEq){
        for (int i=0;i<listaEq.size();i++){
            Serv_Equipo.equipoPrint(listaEq.get(i));
        }
    }

    /** Muestra un equipo
     * @param equipo
     */
    public static void equipoPrint(Equipo equipo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(equipo.getNombre()).append("\n");
        sb.append("Cuit: ").append(equipo.getCUIT()).append("\n");
        sb.append("Dt: ").append(equipo.getDt().getNombre()).append(" ");

        System.out.println(sb.toString());
    }

    public static String construirQuery(DTO_Equipo eq, String tipo) {
        StringBuilder sb = new StringBuilder();
        switch (tipo) {
            case "INSERT":
                sb.append("INSERT INTO equipo (cuit,nombre,dt,idDt) values (");
                sb.append(eq.getDTO_CUIT()).append(",");
                sb.append("'").append(eq.getDTO_nombre()).append("',");
                sb.append("'").append(eq.getDTO_dt()).append("',");
                sb.append("'").append(eq.getDTO_idDt()).append("');");
                break;
            //case "READ":
            //sb.append("SELECT * from Equipo");
            //break;
            //case "DELETE"
            //case "UPDATE"
        }
        return sb.toString();
    }
    //INFORMES
    /**
     * Recorre la lista de jugadores del equipo verificando la existencia de un contrato vigente en la fecha indicada
     *
     * @param equipo
     * @param fecha
     */
    public static void jugadoresPorFecha(Equipo equipo, LocalDate fecha) {
        int contador = 0;
        List<Jugador> listaParaOrdenar = new ArrayList<>();

        System.out.println(equipo.dibujarNombre());

        for (Jugador j : equipo.getListaJugadores()) {
            if (Serv_Jugador.laFechaExisteDentroDeLosContratos(j,fecha, equipo)) {
                listaParaOrdenar.add(j);
            }
        }
        ordenarJugadoresYPrint(listaParaOrdenar);
    }
    /** Ordena la lista alfabéticamente y printea
     * @param listaAux
     */
    private static void ordenarJugadoresYPrint(List<Jugador> listaAux){
        Collections.sort(listaAux);

        for (Jugador j: listaAux){
            Serv_Jugador.printJugador(j);
        }
    }


}
