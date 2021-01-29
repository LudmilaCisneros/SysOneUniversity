
public class RegistroDuplicadoException extends Exception {
    public RegistroDuplicadoException(){
        super("*ERROR* El registro ya es existente en la BD");
    }
}
