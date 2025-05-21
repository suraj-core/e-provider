package io.coredge.health.provide.annotations;

import io.coredge.health.provide.annotations.validator.UuidValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static io.coredge.health.provide.constants.APIBasePathConstants.DeveloperMessage.UUID_MISSMATCH;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

    @Documented
    @Retention(RUNTIME)
    @Constraint(validatedBy = UuidValidator.class)
    @Target({ TYPE, FIELD, PARAMETER })
    public @interface ValidUuid {
        String message() default UUID_MISSMATCH;

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }

