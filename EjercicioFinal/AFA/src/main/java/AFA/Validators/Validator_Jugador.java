package AFA.Validators;

import AFA.DTOs.DTO_Jugador;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Validator_Jugador implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return DTO_Jugador.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"DNI","required.DNI");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre", "required.nombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"posicionActual","required.posicionActual");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cuitEquipo","required.cuitEquipo");
    }
}
