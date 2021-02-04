package otros;

import java.time.LocalDate;
import java.util.ArrayList;

import CapaServicios.Serv_Equipo;
import Entidades.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ludmila Cisneros
 */

public class Main {
    public static void main (String[]args){
        List<Equipo> listaEquipos = new ArrayList<>();
        List<Jugador> listaJugadores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion,opcionAux;

        //----------------//*HARDCODEO DATOS*/----------------//

        //*DTS*//
        Dt dt1 = new Dt("River Plate","Marcelo Gallardo",1);
        Dt dt2 = new Dt("Boca Juniors", "Macri",2);

        //*ARMANDO EQUIPOS*//
        Equipo equipo1 = new Equipo(305879653,"River Plate",dt1);
        Equipo equipo2 = new Equipo(308796542,"Boca Juniors",dt2);

        //*CREANDO JUGADORES*//
        Jugador jugador1 = new Jugador(40987563, "Pepe", 2);
        Jugador jugador2 = new Jugador(23698856, "Pedro", 4);
        Jugador jugador3 = new Jugador(43658978, "Juan", 10);
        Jugador jugador4 = new Jugador(20154698, "Lucas", 10);

        //*CONTRATOS*//
        Serv_Equipo.agregarContratoAlJugador(jugador1,new Contrato(1,305879653,40987563, LocalDate.of(2019,1,12),LocalDate.of(2020,2,10),4)); //
        Serv_Equipo.agregarContratoAlJugador(jugador1,new Contrato(2,308796542,40987563,LocalDate.of(2015,3,5),LocalDate.of(2017,2,10),10));
        Serv_Equipo.agregarContratoAlJugador(jugador2,new Contrato(1,305879653,23698856,LocalDate.of(2019,1,12),LocalDate.of(2020,2,10),4)); //
        Serv_Equipo.agregarContratoAlJugador(jugador2,new Contrato(2,308796542,23698856,LocalDate.of(1990,5,6),LocalDate.of(2001,4,9),10));
        Serv_Equipo.agregarContratoAlJugador(jugador3,new Contrato(1,308796542,43658978,LocalDate.of(2019,2,6),LocalDate.of(2020,4,9),10));

        //*AGREGO JUGADORES A LOS EQUIPOS*//
        equipo1.getListaJugadores().add(jugador1);
        equipo1.getListaJugadores().add(jugador2);
        equipo2.getListaJugadores().add(jugador1);
        equipo2.getListaJugadores().add(jugador2);
        equipo2.getListaJugadores().add(jugador3);

        //*AGREGO LOS EQUIPOS A UNA LISTA DE EQUIPOS*//
        listaEquipos.add(equipo1);
        listaEquipos.add(equipo2);

        //*AGREGO LOS JUGADORES A UNA LISTA DE JUGADORES*//
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        listaJugadores.add(jugador4);


        //MENU

        do{
            System.out.println("┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉┉┅━━━━━━━━━━━┅┉");
            System.out.println("▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂\nＢＩＥＮＶＥＮＩＤＯ\n▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂\n");
            System.out.println("╔════════╗  ╔═══════╗  ╔══════════╗  ╔═══════╗");
            System.out.println(" ①|INSERT    ②|READ    ③|INFORMES    ④|SALIR");
            System.out.println("╚════════╝  ╚═══════╝  ╚══════════╝  ╚═══════╝");
            System.out.println("\nIngrese la opción: ↓ ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("〖INSERT〗\n1)EQUIPO    2)JUGADOR   3)CONTRATO");
                    System.out.println("\nIngrese la opción: ↓ ");
                    opcionAux = sc.nextInt();
                    switch (opcionAux){
                        case 1: System.out.println("\n•◦ •° °• De cuál equipo? •◦ •° °•\n");
                            Controlador.controladorEquipo(listaEquipos,"INSERT");
                            break;
                        case 2: System.out.println("\n•◦ •° °• De cuál jugador? •◦ •° °•\n");
                            Controlador.controladorJugador(listaJugadores,"INSERT");
                            break;
                        case 3: System.out.println("\n•◦ •° °• Seleccione de cual jugador •◦ •° °•\n");
                            Controlador.controladorContrato(listaJugadores,"INSERT");
                            break;
                    }
                    break;

                case 2: System.out.println("〖READ〗\n1)EQUIPO    2)JUGADOR   3)CONTRATO");
                    System.out.println("\nIngrese la opción: ↓ ");
                    opcionAux = sc.nextInt();
                    switch (opcionAux){
                        case 1: Controlador.controladorEquipo(listaEquipos,"READ");
                            break;

                        case 2: Controlador.controladorJugador(listaJugadores,"READ");
                            break;

                        case 3: Controlador.controladorContrato(listaJugadores,"READ");
                            break;
                    }
                    break;

                case 3: Controlador.informeJugadoresPorFecha(listaEquipos);
                    Controlador.informeCantDefensores(listaEquipos);
                    break;

                case 4: break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }while(opcion != 4);
    }

}
