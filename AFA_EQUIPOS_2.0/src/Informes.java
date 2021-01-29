import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Informes {

    /**Recorre la lista de jugadores del equipo verificando la existencia de un contrato vigente en la fecha indicada
     * @param equipo
     * @param fecha
     */
    public static void jugadoresPorFecha(Equipos equipo, LocalDate fecha){
        int contador = 0;
        List<Jugadores> listaParaOrdenar = new ArrayList<>();

        System.out.println(equipo.getNombre());

        for (Jugadores j:equipo.getListaJugadores()){
            if(j.laFechaExisteDentroDeLosContratos(fecha,equipo)){
                listaParaOrdenar.add(j);
            }
        }
        ordenarJugadoresYPrint(listaParaOrdenar);
    }

    /** Ordena la lista alfabéticamente y printea
     * @param listaAux
     */
    private static void ordenarJugadoresYPrint(List<Jugadores> listaAux){
        Collections.sort(listaAux);

        for (Jugadores j: listaAux){
            j.printJugador();
        }
    }
    public static void cargarEquiposBD(List<Equipos> listaEquipos){
        Connection conexion = null;

        String usr = "root";
        String pass = "";
        String ConnectionStr = "jdbc:mariadb://localhost:3306/afa";
        String query = "INSERT INTO equipo (cuit,nombre,dt) values (30568789,'River','Gallardo')";
        //String ConnectionStr = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");

        try{
            //obtenemos el driver para mariadb
            Class.forName("org.mariadb.jdbc.Driver");

            //obtenemos la conexión
            conexion = DriverManager.getConnection(ConnectionStr,usr,pass);

            Statement instruccion = conexion.createStatement();
            instruccion.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
} 