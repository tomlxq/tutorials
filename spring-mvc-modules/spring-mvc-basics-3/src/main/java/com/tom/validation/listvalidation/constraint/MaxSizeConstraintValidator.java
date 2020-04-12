package com.tom.validation.listvalidation.constraint;

import com.tom.validation.listvalidation.model.Movie;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MaxSizeConstraintValidator implements ConstraintValidator<MaxSizeConstraint, List<Movie>> {

    @Override
    public boolean isValid(List<Movie> values, ConstraintValidatorContext context) {
        boolean isValid = true;
        if (values.size() > 4) {
            isValid = false;
        }
        return isValid;
    }

}
