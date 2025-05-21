package io.coredge.health.provide.annotations.validator;

import io.coredge.health.provide.annotations.ValidUuid;
import org.springframework.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class UuidValidator implements ConstraintValidator<ValidUuid, String> {

	String parttern = "[0-9abcdef-]{36}";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return StringUtils.isEmpty(value) || Pattern.compile(parttern).matcher(value).matches();
	}

}
