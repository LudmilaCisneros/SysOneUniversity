import java.util.ArrayList;
import java.util.List;

public class Automovil {
    private Modelo modelo;
    private List<Adicional> listaAdicionales;

    public Automovil(Modelo modelo) {
        this.modelo = modelo;
        this.listaAdicionales = new ArrayList<>();
    }

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
