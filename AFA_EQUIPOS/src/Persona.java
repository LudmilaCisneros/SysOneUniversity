public abstract class Persona {
    private String nombre;
    private Direccion direccion;
    private int telefono;
    private int DNI;

    public Persona(String nombre, Direccion direccion, int telefono, int DNI) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.DNI = DNI;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public int getDNI() {
        return this.DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
}