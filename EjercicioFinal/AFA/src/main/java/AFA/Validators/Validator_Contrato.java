package AFA.Validators;

import AFA.DTOs.DTO_Contrato;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Validator_Contrato implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return DTO_Contrato.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"idContrato","required.idContrato");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"fechaIn", "required.fechaIn");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"fechaFin","required.fechaFin");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"posicion","required.posicion");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombreClub","required.nombreClub");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"dni_jugador","required.dni_jugador");

    }
}
