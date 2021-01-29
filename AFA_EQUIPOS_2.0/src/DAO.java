import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO<T> {
    private final String connectionStr = "jdbc:mariadb://localhost:3306/afa";
    private final String usr = "root";
    private final String pass = "";



    //IF EXISTE EL EQUIPO
    public boolean hacerInsert(T datos, String query) {
        Connection conexion = null;
        boolean result = true;

        try {
            //obtenemos el driver para mariadb
            Class.forName("org.mariadb.jdbc.Driver");

            //obtenemos la conexión
            conexion = DriverManager.getConnection(connectionStr, usr, pass);
            Statement instruccion = conexion.createStatement();
            instruccion.executeQuery(query);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null)
                    conexion.close();
            } catch (Exception ex) {
                System.out.println("No se cerró la conexion con BD");
                ex.printStackTrace();
            }
        }
        return result;
    }
/*
    public List<String> hacerSelect(String tipo,String query) {
        Connection conexion = null;
        List<String> lista = new ArrayList<>();
        boolean flag = true;
        boolean result = true;

        try {
            //obtenemos el driver para mariadb
            Class.forName("org.mariadb.jdbc.Driver");

            //obtenemos la conexión
            conexion = DriverManager.getConnection(connectionStr, usr, pass);
            Statement instruccion = conexion.createStatement();
            ResultSet rs = instruccion.executeQuery(query);

            while(rs.next()){
                if(flag){
                    flag = false;
                    switch (tipo){
                        case "Equipos":
                            List<Equipos> listaEq = new ArrayList<>();
                            break;
                        case "Jugadores":
                            List<Jugadores> listJug = new ArrayList<>();
                            break;
                        case "Dts":
                            List<Dts> listDts = new ArrayList<>();
                            break;
                    }
                }
                switch (tipo){
                    case "Equipos":

                        lista.add(rs.getInt("cuit"),rs.getString("nombre"),rs.getString("dt"));
                        break;
                    case "Jugadores":
                    case "Dts":
                        break;
                }

            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null)
                    conexion.close();
            } catch (Exception ex) {
                System.out.println("No se cerró la conexion con BD");
                ex.printStackTrace();
            }
        }
        return lista;
    }*/
}

