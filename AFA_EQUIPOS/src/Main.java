import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main (String[]args){
//*DTS*// 
        Dts dt1 = new Dts("Marcelo Gallardo", new Direccion("1 de mayo", 698, "S.M. Punilla", "Córdoba"), 46987534, 23587965, "River Plate", LocalDate.of(2000, 2, 10), LocalDate.of(2020, 5, 20));
        Dts dt2 = new Dts("Ni idea", new Direccion("1 de mayo", 698, "S.M. Punilla", "Córdoba"), 46987534, 23587965, "Boca Juniors", LocalDate.of(2000, 2, 10), LocalDate.of(2020, 5, 20));
        Dts dt3 = new Dts("Pedro Mendoza", new Direccion("1 de mayo", 698, "S.M. Punilla", "Córdoba"), 46987534, 23587965, "Independiente", LocalDate.of(2000, 2, 10), LocalDate.of(2020, 5, 20));

//*LISTA JUGADORES*// 
        ArrayList<Jugadores> listaJugadores1 = new ArrayList();
        ArrayList<Jugadores> listaJugadores2 = new ArrayList();
        ArrayList<Jugadores> listaJugadores3 = new ArrayList();

//*CREANDO JUGADORES*// 
        Jugadores jugador1 = new Jugadores("Pepe", 78965412, 40987563, new Direccion("Saraza", 5687, "CABA", "Bs AS"), "River Plate", LocalDate.of(1990, 12, 1), LocalDate.of(2019, 10, 2), LocalDate.of(1970, 1, 12), LocalDate.of(1989, 1, 12), 60, 20, 80, 182, 5);
        listaJugadores1.add(jugador1);
        Jugadores jugador2 = new Jugadores("Raul", 98546268, 23654784, new Direccion("Mendez", 968, "CABA", "Bs AS"), "River Plate", LocalDate.of(1990, 12, 1), LocalDate.of(2019, 10, 2), LocalDate.of(1970, 1, 12), LocalDate.of(1989, 1, 12), 60, 20, 80, 182, 10);
        listaJugadores1.add(jugador2);
        Jugadores jugador3 = new Jugadores("Andres", 78965412, 40987563, new Direccion("México", 5687, "CABA", "Bs AS"), "Boca Juniors", LocalDate.of(1990, 12, 1), LocalDate.of(2019, 10, 2), LocalDate.of(1970, 1, 12), LocalDate.of(1989, 1, 12), 60, 20, 80, 182, 2);
        listaJugadores2.add(jugador3);
        Jugadores jugador4 = new Jugadores("Nahuel", 78965412, 40987563, new Direccion("Jujuy", 5687, "CABA", "Bs AS"), "Boca Juniors", LocalDate.of(1990, 12, 1), LocalDate.of(2019, 10, 2), LocalDate.of(1970, 1, 12), LocalDate.of(1989, 1, 12), 60, 20, 80, 182, 10);
        listaJugadores2.add(jugador4);
        Jugadores jugador5 = new Jugadores("Javier", 78965412, 40987563, new Direccion("Mendoza", 5687, "CABA", "Bs AS"), "Independiente", LocalDate.of(1990, 12, 1), LocalDate.of(2019, 10, 2), LocalDate.of(1970, 1, 12), LocalDate.of(1989, 1, 12), 60, 20, 80, 182, 2);
        listaJugadores3.add(jugador5);
        Jugadores jugador6 = new Jugadores("Julian", 78965412, 40987563, new Direccion("Italia", 5687, "CABA", "Bs AS"), "Independiente", LocalDate.of(1990, 12, 1), LocalDate.of(2019, 10, 2), LocalDate.of(1970, 1, 12), LocalDate.of(1989, 1, 12), 60, 20, 80, 182, 9);
        listaJugadores3.add(jugador6);

//*ARMANDO EQUIPOS*// 
        Equipos equipo1 = new Equipos("River Plate", LocalDate.of(1997, 1, 12), "Roberto Juarez", new Direccion("Olazabal", 2556, "Nuñez", "Buenos Aires"), 45689875, "consultas@riverplateoficial.com.ar", LocalDate.of(1998, 2, 10), LocalDate.of(2005, 5, 20), 'A', dt1, listaJugadores1);
        Equipos equipo2 = new Equipos("Boca Juniors", LocalDate.of(1997, 1, 12), "Roberto Juarez", new Direccion("Olazabal", 2556, "Nuñez", "Buenos Aires"), 45689875, "consultas@bocajuniorsoficial.com.ar", LocalDate.of(1998, 2, 10), LocalDate.of(2005, 5, 20), 'A', dt2, listaJugadores2);
        Equipos equipo3 = new Equipos("Independiente", LocalDate.of(1997, 1, 12), "Roberto Juarez", new Direccion("Olazabal", 2556, "Nuñez", "Buenos Aires"), 45689875, "consultas@Independienteoficial.com.ar", LocalDate.of(1998, 2, 10), LocalDate.of(2005, 5, 20), 'A', dt3, listaJugadores3);

//*INFORMES*// 

//a) Cuantos jugadores tiene cada equipo? Ordenados alfabeticamente. 
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
        Informes.defensoresPorEquipo(equipo3);
    }
} 