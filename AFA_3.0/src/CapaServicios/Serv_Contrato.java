package CapaServicios;

import DAOs.DAO_Contrato;
import DTOs.DTO_Contrato;
import Entidades.Contrato;
import Entidades.Jugador;
import java.util.ArrayList;
import java.util.List;

public class Serv_Contrato {

    public void insert(DTO_Contrato obj) {
        DAO_Contrato consulta = new DAO_Contrato();

        String query = construirQuery(obj, "INSERT");

        if(consulta.hacerInsert(obj, query))
            System.out.println("El insert del contrato ID: " + obj.getDTO_idContrato() + " fue exitoso.");
    }

    public void read() {
        DAO_Contrato consulta = new DAO_Contrato();
        List<DTO_Contrato> contratosDTO = new ArrayList<>();
        List<Contrato> contratos = new ArrayList<>();

        contratosDTO = consulta.hacerSelect("SELECT * from contrato");
        contratos = convertirContratosDTOAContratos(contratosDTO);
        Serv_Contrato.printContratos(contratos);
    }


    /** Muestra los contratos
     * @param contratos
     */
    public static void printContratos(List<Contrato> contratos) {
        for (Contrato c: contratos) {
            printContrato(c);
        }
    }

    /**
     * Muestra el contrato
     */
    public static void printContrato(Contrato c){
        StringBuilder sb = new StringBuilder();

        sb.append("ID CONTRATO: ").append(c.getIdContrato());
        sb.append(" Dni Jugador: ").append(c.getDniJugador());
        sb.append(" cuit Equipo: ").append(c.getCuitEquipo());
        sb.append(" F INICIAL: ").append(c.getFechaIn());
        sb.append(" F FINAL: ").append(c.getFechaFin());
        sb.append(" POSICION: ").append(c.getPosicion()).append("\n");

        System.out.println(sb.toString());
    }


    /** Convierte los DTOContratos a Contratos
     * @param listaDTO
     * @return
     */
    public static List<Contrato> convertirContratosDTOAContratos(List<DTO_Contrato> listaDTO){
        List<Contrato> contratos = new ArrayList<>();

        for (int i=0;i<listaDTO.size();i++){
            contratos.add(convertirDTOAContrato(listaDTO.get(i)));
        }
        return contratos;
    }


    /** Convierte el contrato a DTO
     * @param contrato
     * @return
     */
    public static DTO_Contrato convertirContratoADTO(Contrato contrato) {
        return new DTO_Contrato(contrato);
    }

    /** Convierte el DTO a Contrato
     * @param cDTO
     * @return
     */
    public static Contrato convertirDTOAContrato(DTO_Contrato cDTO) {
        return new Contrato(cDTO);
    }

    public String construirQuery(DTO_Contrato contrato, String tipo) {
        StringBuilder sb = new StringBuilder();
        switch (tipo) {
            case "INSERT":
                sb.append("INSERT INTO contrato (idContrato,dniJugador,cuitEquipo,fInicial,fFinal,posicion) values (");
                sb.append(contrato.getDTO_idContrato()).append(",");
                sb.append("'").append(contrato.getDTO_dniJugador()).append("',");
                sb.append("'").append(contrato.getDTO_cuitEquipo()).append("',");
                sb.append("'").append(contrato.getDTO_fechaIn()).append("',");
                sb.append("'").append(contrato.getDTO_fechaFin()).append("',");
                sb.append("'").append(contrato.getDTO_posicion()).append("');");
                break;
            //case "READ":
            //sb.append("SELECT * from Equipo");
            //break;
            //case "DELETE"
            //case "UPDATE"
        }
        return sb.toString();
    }

    /** Primero verifica que no exista el contrato en el jugador, si no existe lo agrega a la lista de contratos
     * @param contrato
     * @return (true) si lo agregó, (false) si no.
     */
    public boolean agregarContrato(Jugador jugador, Contrato contrato){
        for (Contrato con:jugador.getListaContratos()) {
            if(con.equals(contrato)){
                System.out.println("El jugador " + jugador.getNombre() + "posee un contrato duplicado.");
                return false;
            }
        }
        jugador.getListaContratos().add(contrato);
        return true;
    }

}