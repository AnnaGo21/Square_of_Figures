package com.example.square.model;

import com.example.square.validator.PositiveArrayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositiveArrayValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface PositiveArray {
    String message() default "Dimensions must be positive values.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}