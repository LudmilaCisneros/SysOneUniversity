import java.util.ArrayList;
import java.util.List;

public class Equipos{
    private int CUIT;// PK
    private String nombre;
    private Dts dt;
    private List<Jugadores> listaJugadores;

    public Equipos(int CUIT, String nombre, Dts dt) {
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.dt = dt;
        this.listaJugadores = new ArrayList<>();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(this.nombre).append("\n");
        sb.append("Cuit: ").append(this.CUIT).append("\n");
        sb.append("Dt: ").append(this.dt.getNombre()).append(" ");
        return sb.toString();
    }
    public void printNombreEquipo(){
        System.out.print("Club: " + this.nombre);
    }

    public String construirQuery(String tipo){
        StringBuilder sb = new StringBuilder();
        switch (tipo){
            case "INSERT":
                sb.append("INSERT INTO equipo (cuit,nombre,dt) values (");
                sb.append(this.CUIT).append(",");
                sb.append("'").append(this.nombre).append("',");
                sb.append("'").append(this.dt.getNombre()).append("');");
                break;
            //case "SELECTONE"
            //case "DELETE"
            //case "UPDATE"
        }
        return sb.toString();
    }
    /** Inserta el equipo pasado por parametro
     */
    public void insert(){
        boolean result = false;
        DAO<Equipos> consulta;
        String query = this.construirQuery("INSERT");

        consulta = new DAO<>(); //sb.toString()
        result = consulta.hacerInsert(this,query);

        if(result){
            System.out.println("El insert del equipo: " + this.getNombre() + " fue exitoso.");
        }else{
            System.out.println("Ha ocurrido un error al insertar ");
            this.printNombreEquipo();
            System.out.println(".");
        }
    }

    public static List<Equipos> select() {
        List<Equipos> lista = new ArrayList<>();
        lista = null;
        DAO<Equipos> consulta;
        String query = ("SELECT * from equipo;");

        consulta = new DAO<>(); //sb.toString()
        lista = consulta.hacerSelect("Equipos",query);

        return lista;
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public String getNombre() {
        StringBuilder sb = new StringBuilder();
        sb.append("**************");
        sb.append("*").append(nombre).append("*");
        sb.append("**************");
        return sb.toString();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dts getDt() {
        return dt;
    }

    public void setDt(Dts dt) {
        this.dt = dt;
    }

    public List<Jugadores> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugadores> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

}
