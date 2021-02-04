package DAOs;

import DTOs.DTO_Equipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Equipo {
    private final String connectionStr = "jdbc:mariadb://localhost:3306/afa";
    private final String usr = "root";
    private final String pass = "";

    public boolean hacerInsert(DTO_Equipo equipo, String query) {
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

    public List<DTO_Equipo> hacerSelect(String query) {
        Connection conexion = null;
        boolean result = true;
        List<DTO_Equipo> listaEq = new ArrayList<>();

        try {
            //obtenemos el driver para mariadb
            Class.forName("org.mariadb.jdbc.Driver");
            //obtenemos la conexión
            conexion = DriverManager.getConnection(connectionStr, usr, pass);
            Statement instruccion = conexion.createStatement();
            ResultSet rs = instruccion.executeQuery(query);
            while(rs.next()){
                listaEq.add(new DTO_Equipo(rs.getInt("cuit"), rs.getString("nombre"), rs.getString("dt"), rs.getInt("idDt")));
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