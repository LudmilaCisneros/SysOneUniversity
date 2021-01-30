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
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (conexion != null)
                    conexion.close();
            } catch (Exception ex) {
                System.out.println("No se cerró la conexion con BD");
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public List<Equipos> hacerSelect(String tipo,String query) {
        Connection conexion = null;
        boolean result = true;
        List<Equipos> listaEq = new ArrayList<>();

        try {
            //obtenemos el driver para mariadb
            Class.forName("org.mariadb.jdbc.Driver");
            //obtenemos la conexión
            conexion = DriverManager.getConnection(connectionStr, usr, pass);
            Statement instruccion = conexion.createStatement();
            ResultSet rs = instruccion.executeQuery(query);
            while(rs.next()){
                listaEq.add(new Equipos(rs.getInt("cuit"), rs.getString("nombre"), new Dts(rs.getString("dt"))));
            }
        } catch (Exception e) {
            result = false;
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conexion != null)
                    conexion.close();
            } catch (Exception ex) {
                System.out.println("No se cerró la conexion con BD");
                System.out.println(ex.getMessage());
            }
        }
        return listaEq;
    }
}

