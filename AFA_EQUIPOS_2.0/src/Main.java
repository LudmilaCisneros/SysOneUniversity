import javax.sound.sampled.Line;
import java.time.LocalDate;

/**
 * @author Ludmila Cisneros
 */

public class Main {
    public static void main (String[]args){
        /*DTS*/
        Dts dt1 = new Dts(1,"River Plate","Marcelo Gallardo");
        Dts dt2 = new Dts(2,"Boca Juniors", "Macri");
        Dts dt3 = new Dts(3,"Pedro Mendoza", "Independiente");

        /*ARMANDO EQUIPOS*/
        Equipos equipo1 = new Equipos(305879653,"River Plate",dt1);
        Equipos equipo2 = new Equipos(308796542,"Boca Juniors",dt2);
        Equipos equipo3 = new Equipos(305489651, "Independiente",dt3);

        /*CREANDO JUGADORES*/
        Jugadores jugador1 = new Jugadores(40987563, "Pepe", 2);
        Jugadores jugador2 = new Jugadores(23698856, "Pedro", 4);
        Jugadores jugador3 = new Jugadores(43658978, "Juan", 10);
        Jugadores jugador4 = new Jugadores(20154698, "Lucas", 10);

        /*CONTRATOS*/
        jugador1.agregarContrato(new Contrato(1,305879653,40987563,LocalDate.of(2019,1,12),LocalDate.of(2020,2,10),4));
        jugador1.agregarContrato(new Contrato(2,308796542,40987563,LocalDate.of(2015,1,12),LocalDate.of(2017,2,10),10));
        jugador2.agregarContrato(new Contrato(3,308796542,23698856,LocalDate.of(2019,1,12),LocalDate.of(2020,2,10),4));

/*INFORMES
c)Cuantos jugadores hubo en una fecha en los clubes ordenado alfabeticamente *EN TODOS**/
        Informes.JugadoresPorFecha(equipo1, LocalDate.of(2019,1,12));
        Informes.JugadoresPorFecha(equipo2, LocalDate.of(2019,1,12));
        Informes.JugadoresPorFecha(equipo3, LocalDate.of(2019,1,12));


/*a) Cuantos jugadores tiene cada equipo? Ordenados alfabeticamente.
        System.out.println("La cantidad de jugadores del equipo 1 es: ");
        Informes.cantJugadoresPorEquipo(equipo1);
        System.out.println("La cantidad de jugadores del equipo 2 es: ");
        Informes.cantJugadoresPorEquipo(equipo2);
        System.out.println("La cantidad de jugadores del equipo 3 es: ");
        Informes.cantJugadoresPorEquipo(equipo3);

        Informes.ordenarJugadoresAlfabPorEquipo(equipo1);
        Informes.ordenarJugadoresAlfabPorEquipo(equipo2);
        Informes.ordenarJugadoresAlfabPorEquipo(equipo3);

//b) Cuántos defensores tiene cada equipo? 
        System.out.println("La cantidad de defensores del equipo 1 es: ");
        Informes.defensoresPorEquipo(equipo1);
        System.out.println("La cantidad de defensores del equipo 2 es: ");
        Informes.defensoresPorEquipo(equipo2);
        System.out.println("La cantidad de defensores del equipo 3 es: ");
        Informes.defensoresPorEquipo(equipo3);*/

    }
} 