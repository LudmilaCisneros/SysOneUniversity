package AFA.Validators;

import AFA.DTOs.DTO_Dt;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Validator_Dt implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return DTO_Dt.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id_dt","required.idDt");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","required.nombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cuitEquipo","required.cuitEquipo");
    }
}
