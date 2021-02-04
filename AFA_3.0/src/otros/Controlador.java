package otros;

import CapaServicios.Serv_Contrato;
import CapaServicios.Serv_Equipo;
import CapaServicios.Serv_Jugador;
import Entidades.Contrato;
import Entidades.Equipo;
import Entidades.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {

    public static void controladorEquipo(List<Equipo> list, String query) {
        Scanner sc = new Scanner(System.in);
        int opcionInt;
        String opcionStr;
        Serv_Equipo se= new Serv_Equipo();
        List<Equipo> aux = new ArrayList<>();

        if (query.equals("INSERT")) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(i + 1 + ") ");
                System.out.println(list.get(i).getNombre());
                //System.out.print(". \n");
            }
            System.out.println("\nIngrese la opcion: ↓");
            opcionStr = sc.next();
            if (isNumeric(opcionStr)) {
                opcionInt = Integer.parseInt(opcionStr);
                se.insert(Serv_Equipo.convertirEquipoADTO(list.get(opcionInt - 1))); //! parseo de equipo a DTO y insert
            }
        }
        if(query.equals("READ")){
            se.read();
        }
    }

    public static void controladorJugador(List<Jugador> list, String query) {
        Scanner sc = new Scanner(System.in);
        int opcionInt;
        String opcionStr;
        Serv_Jugador sj= new Serv_Jugador();
        List<Jugador> aux = new ArrayList<>();

        if (query.equals("INSERT")) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(i + 1 + ") ");
                System.out.println(list.get(i).getNombre());
                //System.out.print(". \n");
            }
            System.out.println("\nIngrese la opcion: ↓");
            opcionStr = sc.next();
            if (isNumeric(opcionStr)) {
                opcionInt = Integer.parseInt(opcionStr);
                sj.insert(Serv_Jugador.convertirJugadorADTO((list.get(opcionInt - 1)))); //! parseo de equipo a DTO y insert
            }
        }
        if(query.equals("READ")){
            sj.read();
        }
    }

    public static void controladorContrato(List<Jugador> list, String query) {
        Scanner sc = new Scanner(System.in);
        int opcionInt, opcionIntAux;
        String opcionStr;
        Serv_Contrato sC = new Serv_Contrato();
        List<Contrato> aux = new ArrayList<>();

        if (query.equals("INSERT")) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(i + 1 + ") ");
                System.out.println(list.get(i).getNombre());
            }
            System.out.println("\nIngrese la opcion: ↓");
            opcionStr = sc.next();
            if (isNumeric(opcionStr)) {
                opcionInt = Integer.parseInt(opcionStr);
                System.out.println("\n•◦ •° °• De qué contrato? •◦ •° °•\n");
                for (int j = 0; j < list.get(opcionInt - 1).getListaContratos().size(); j++) {
                    System.out.print(j + 1 + ") ");
                    Serv_Contrato.printContrato(list.get(opcionInt - 1).getListaContratos().get(j));
                }
                System.out.println("\nIngrese la opcion: ↓");
                opcionStr = sc.next();
                if (isNumeric(opcionStr)) {
                    opcionIntAux = Integer.parseInt(opcionStr);
                    sC.insert(Serv_Contrato.convertirContratoADTO((list.get(opcionInt - 1).getListaContratos().get(opcionIntAux - 1))));
                }
            }
        }
        if (query.equals("READ")) {
            sC.read();
        }
    }

    /**Verifica que el Str sea un entero
     * @param str
     * @return aux
     */
    public static boolean isNumeric (String str){
        int aux = -1;
        try {
            aux = Integer.parseInt(str);
            if (aux != -1)
                return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /** Muestra los jugaadores que tienen contratos activos en la fecha 12/3/2019
     * @param listaEquipos
     */
    public static void informeJugadoresPorFecha(List<Equipo> listaEquipos){
        if(listaEquipos.size() > 0){
            System.out.println("******************************************************************");
            System.out.println("* En la fecha 12/3/2019 estaban activos los siguientes contratos *");
            System.out.println("******************************************************************\n");

            for (Equipo eq:listaEquipos) {
                Serv_Equipo.jugadoresPorFecha(eq, LocalDate.of(2019,3,12));
            }
        }
        else{
            System.out.println("No hay equipos cargados en sistema.");
        }
    }


    /** Muestra la cantidad de defensores de todos los equipos
     * @param listaEquipos
     */
    public static void informeCantDefensores(List<Equipo> listaEquipos){
        int contadorDefensores;

        for (Equipo eq : listaEquipos) {
            contadorDefensores = 0;
            for (Jugador j:eq.getListaJugadores()) {
                if(j.getPosicionActual() >= 2 && j.getPosicionActual() <= 5){
                    contadorDefensores++;
                }
            }
            System.out.println("El equipo "+eq.getNombre()+" tiene "+ contadorDefensores + " defensores.");

        }
    }
}
