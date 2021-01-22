public class Adicional {
    private int id;
    private String descripcion;
    private float precio;

    public Adicional(int id,String descripcion, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

}
