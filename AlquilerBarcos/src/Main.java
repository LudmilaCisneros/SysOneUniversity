import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ludmila Cisneros
 */

public class Main {
    public static void main(String[] args){

        //Alquiler[] listaAlquileres = new Alquiler[4];
        ArrayList<Alquiler> listaAlquileres = new ArrayList<Alquiler>();

        listaAlquileres.add(new Alquiler("Juan",40256896,LocalDate.of(2020, 1, 15),
                LocalDate.of(2020, 1, 20),20, new Velero(1,20,2000,5)));

        listaAlquileres.add(new Alquiler("Carla",22986354,LocalDate.of(2020, 3, 2),
                LocalDate.of(2020, 3, 10),10, new Yate(2,15,2013,1000,10)));

        listaAlquileres.add(new Alquiler("Lucas",30248965,LocalDate.of(2020, 11, 6),
                LocalDate.of(2020, 12, 6),20, new Deportivo(3,30,1998,3000)));

        listaAlquileres.add(new Alquiler("Matias",60248965,LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 6),15, new Velero(3,30,2008,10)));
        /*
        listaAlquileres[0] = new Alquiler("Juan",40256896,LocalDate.of(2020, 1, 15),
                LocalDate.of(2020, 1, 20),20, new Velero(1,20,2000,5));

        listaAlquileres[1] = new Alquiler("Carla",22986354,LocalDate.of(2020, 3, 2),
                LocalDate.of(2020, 3, 10),10, new Yate(2,15,2013,1000,10));

        listaAlquileres[2] = new Alquiler("Lucas",30248965,LocalDate.of(2020, 11, 6),
                LocalDate.of(2020, 12, 6),20, new Deportivo(3,30,1998,3000));

        listaAlquileres[3] = new Alquiler("Matias",60248965,LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 6),15, new Velero(3,30,2008,10));*/

        Calculos.mayorAlquiler(listaAlquileres);
        Calculos.menorAlquiler(listaAlquileres);
        Calculos.promedioAnual(listaAlquileres);
        Calculos.promedioMensual(listaAlquileres);


    }
}
