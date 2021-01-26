import java.time.LocalDate;

/**
 * @author Ludmila Cisneros
 */

public class Main {
    public static void main (String[]args){
        //*DTS*//
        Dts dt1 = new Dts(1,"River Plate","Marcelo Gallardo");
        Dts dt2 = new Dts(2,"Boca Juniors", "Macri");

        //*ARMANDO EQUIPOS*//
        Equipos equipo1 = new Equipos(305879653,"River Plate",dt1);
        Equipos equipo2 = new Equipos(308796542,"Boca Juniors",dt2);

        //*CREANDO JUGADORES*//
        Jugadores jugador1 = new Jugadores(40987563, "Pepe", 2);
        Jugadores jugador2 = new Jugadores(23698856, "Pedro", 4);
        Jugadores jugador3 = new Jugadores(43658978, "Juan", 10);
        Jugadores jugador4 = new Jugadores(20154698, "Lucas", 10);

        //*CONTRATOS*//
        jugador1.agregarContrato(new Contrato(1,305879653,40987563,LocalDate.of(2019,1,12),LocalDate.of(2020,2,10),4)); //
        jugador1.agregarContrato(new Contrato(2,308796542,40987563,LocalDate.of(2015,3,5),LocalDate.of(2017,2,10),10));
        jugador2.agregarContrato(new Contrato(1,305879653,23698856,LocalDate.of(2019,1,12),LocalDate.of(2020,2,10),4)); //
        jugador2.agregarContrato(new Contrato(2,308796542,23698856,LocalDate.of(1990,5,6),LocalDate.of(2001,4,9),10));
        jugador3.agregarContrato(new Contrato(1,308796542,43658978,LocalDate.of(2019,2,6),LocalDate.of(2020,4,9),10));

        equipo1.getListaJugadores().add(jugador1);
        equipo1.getListaJugadores().add(jugador2);
        equipo2.getListaJugadores().add(jugador1);
        equipo2.getListaJugadores().add(jugador2);
        equipo2.getListaJugadores().add(jugador3);

        //*INFORMES*//
        //c)Cuantos jugadores hubo en una fecha en los clubes ordenado alfabeticamente *EN TODOS*

        System.out.println("******************************************************************");
        System.out.println("* En la fecha 12/3/2019 estaban activos los siguientes contratos *");
        System.out.println("******************************************************************\n");

        Informes.jugadoresPorFecha(equipo1, LocalDate.of(2019,3,12));
        Informes.jugadoresPorFecha(equipo2, LocalDate.of(2019,3,12));

    }
} 