package AFA.Validators;

import AFA.DTOs.DTO_Equipo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Validator_Equipo implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return DTO_Equipo.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"CUIT","required.CUIT");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre", "required.nombre");
    }
}
