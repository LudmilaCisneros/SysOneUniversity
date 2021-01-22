import java.util.ArrayList;
import java.util.List;

public class Automovil {

    private int id;
    private Modelo modelo;
    private List<Adicional> listaAdicionales;

    public Automovil(int id, Modelo modelo) {
        this.id = id;
        this.modelo = modelo;
        this.listaAdicionales = new ArrayList<>();
    }

    public int getId() { return id; }

    public Modelo getModelo() {
        return modelo;
    }

    public List<Adicional> getListaAdicionales() {
        return listaAdicionales;
    }

    public void agregarAdicional(Adicional adicional) {
        this.listaAdicionales.add(adicional);
    }

    private float calcularCostoAdicional(){
        float precioTotal = 0;

        for (Adicional adic: this.listaAdicionales) {
            precioTotal += adic.getPrecio();
        }
        return precioTotal;
    }

    public float calcularCostoFinal(){
        float precioModelo = this.modelo.getPrecio();
        float precioAdicionales = this.calcularCostoAdicional();

        return (precioModelo + precioAdicionales);
    }


}
