import java.util.ArrayList;
import java.util.List;

public class Equipos implements IQuery{//implements IQuery<Equipos>{
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
    public void printNombreEquipo(){
        System.out.print("Club: " + this.nombre);
    }

    public String construirQuery(String tipo){
        StringBuilder sb = new StringBuilder();
        //"INSERT INTO equipo (cuit,nombre,dt) values (30568789,'River','Gallardo')";
        switch (tipo){
            case "INSERT":
                sb.append("INSERT INTO equipo (cuit,nombre,dt) values (");
                sb.append(this.CUIT).append(",");
                sb.append("'").append(this.nombre).append("',");
                sb.append("'").append(this.dt.getNombre()).append("');");
                break;
            case "SELECTALL"://TODOS
                sb.append("SELECT * from equipo;");
                break;
            //case "SELECT "
            //delete
            //update

        }
        return sb.toString();
    }
    /** Inserta el equipo pasado por parametro
     */
    public void insert(){
        boolean result = false;
        DAO<Equipos> consulta;
        String query = this.construirQuery("INSERT");

        try{
            consulta = new DAO<>(); //sb.toString()
            result = consulta.hacerInsert(this,query);
            if(!result){
                throw new RegistroDuplicadoException();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage()); //REVISAR MANEJO DE EXCEPCIONES
        }

        finally {
            if(result){
                System.out.println("El insert del equipo: " + this.getNombre() + " fue exitoso.");
            }else{
                System.out.println("Ha ocurrido un error al insertar ");
                this.printNombreEquipo();
                System.out.println(".");
            }
        }
    }
    public List<String> select() {
        List<String> lista = new ArrayList<>();
        lista = null;
        DAO<Equipos> consulta;
        String query = this.construirQuery("SELECTALL");

        try{
            consulta = new DAO<>(); //sb.toString()
            //lista = consulta.hacerSelect("Equipos",query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(lista != null){
                System.out.println("El insert del equipo: " + this.getNombre() + " fue exitoso.");
            }else{
                System.out.println("Ha ocurrido un error al insertar el equipo: " + this.getNombre() + ".");
            }
        }
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
