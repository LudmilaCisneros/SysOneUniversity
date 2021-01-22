public class Adicional {
    private String descripcion;
    private float precio;

    public Adicional(String descripcion, float precio) {
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
