import java.time.*;
import static java.time.temporal.ChronoUnit.DAYS;

public class Alquiler {
    private String nombreCliente;
    private int dniCliente;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int posicionAmarre;
    private Barco barco;
    private int valorFijoAlquilerCte;

    public String getNombreCliente(){
        return this.nombreCliente;
    }
    public int getDniCliente(){
        return this.dniCliente;
    }
    public LocalDate getFechaInicial() { return this.fechaInicial; }
    public LocalDate getFechaFinal(){
        return this.fechaFinal;
    }
    public int getMonthFechaInicial(){
        return this.fechaInicial.getMonthValue();
    }
    public int getMonthFechaFinal(){
        return this.fechaFinal.getMonthValue();
    }
    public int getPosicionAmarre(){
        return this.posicionAmarre;
    }
    public int getValorFijoAlquilerCte(){
        return this.valorFijoAlquilerCte;
    }

    public Alquiler(String nombreCliente,int dniCliente,LocalDate fechaInicial,
                    LocalDate fechaFinal,int posicionAmarre, Barco barco){

        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
        this.valorFijoAlquilerCte = calcularAlquiler();
    }

    /**
     * @brief Calcula cuantos dias tiene un alquiler
     * @return (int) dias
     */
    public int calcularDiasDeAlquiler(){

    return (int) DAYS.between(this.fechaInicial,this.fechaFinal);
    }

    /**
     * @brief Calcula el valor del alquiler
     * @return (int) precio
     */
    private int calcularAlquiler(){

        int cantDiasAlquiler = this.calcularDiasDeAlquiler();
        int modulo = this.barco.calcularModulo();

        return (cantDiasAlquiler * modulo * 2);
    }

    /**
     * @brief Muestra por consola los datos del alquiler
     */
    public static void printAlquiler(Alquiler alq){
        System.out.println("** Datos del titular **");
        System.out.println("Nombre: "+ alq.getNombreCliente());
        System.out.println("Dni: "+ alq.getDniCliente());
        System.out.println("Fecha inicial: "+ alq.getFechaInicial());
        System.out.println("Fecha final: "+ alq.getFechaFinal());
        System.out.println("Valor alquiler: $"+ alq.getValorFijoAlquilerCte());
        System.out.println(" ");
        System.out.println("** Datos del barco **");
        alq.barco.printBarco();
        System.out.println("**********************************************");
        System.out.println(" ");
    }

}
