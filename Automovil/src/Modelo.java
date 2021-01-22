public class Modelo {
    private String descripcion;
    private float precio;

    public Modelo(String descripcion, float precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }
}
