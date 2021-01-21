public class Direccion {
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public Direccion(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return this.calle;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public String getProvincia() {
        return this.provincia;
    }
}