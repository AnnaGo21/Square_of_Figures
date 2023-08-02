package com.example.square.validator;

import com.example.square.model.PositiveArray;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PositiveArrayValidator implements ConstraintValidator<PositiveArray, int[]> {
    @Override
    public boolean isValid(int[] value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        for (int i : value) {
            if (i <= 0) {
                return false;
            }
        }

        return true;
    }
}