package io.coredge.health.provide.exception.handler;


import io.coredge.health.provide.exception.AuthenticationException;
import io.coredge.health.provide.exception.BusinessException;
import io.coredge.health.provide.exception.model.ApiError;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static io.coredge.health.provide.exception.model.ErrorCode.SYSTEM_EXCEPTION;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class GlobalExceptionHandler {

	private static final String EXCEPTION_MSG_FORMAT = "{} Execption occured while procssing the request. Exception : ";
	private ExceptionHelper helper;

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException authExp, WebRequest request) {
		log.warn(EXCEPTION_MSG_FORMAT + "{}", "Authentication", authExp.getMessage());
		return new ResponseEntity<>(helper.apiError(authExp, request.getLocale()), UNAUTHORIZED);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiError> handleBusinessException(BusinessException busExp, WebRequest request) {
		log.error(EXCEPTION_MSG_FORMAT + "{}", "Business", busExp.getMessage());
		return ResponseEntity.unprocessableEntity().body(helper.apiError(busExp, request.getLocale()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleSystemException(Exception sysExp, WebRequest request) {
		log.error(EXCEPTION_MSG_FORMAT, "System", sysExp);
		return new ResponseEntity<>(helper.apiError(SYSTEM_EXCEPTION, request.getLocale()), INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException valExp,
			WebRequest request) {
		return ResponseEntity.badRequest().body(helper.apiError(valExp, request.getLocale()));
	}
}
