package com.tom.javaxval.enums;

import com.tom.javaxval.enums.constraints.ValueOfEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence> {
   private List<String> acceptedValues;

   @Override
   public void initialize(ValueOfEnum annotation) {
      acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
              .map(Enum::name)
              .collect(Collectors.toList());
   }

   @Override
   public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
      if (value == null) {
         return true;
      }

      return acceptedValues.contains(value.toString());
   }
}
