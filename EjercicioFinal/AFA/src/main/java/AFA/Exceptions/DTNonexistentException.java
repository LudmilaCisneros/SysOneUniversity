package AFA.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DTNonexistentException extends InternalServerErrorException{
    private static final String informacion = "Dt no existe";

    public DTNonexistentException() {
        super(informacion);
    }
}
