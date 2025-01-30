package com.siagi.simplifica.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.siagi.simplifica.domain.integracao.IntegracaoValidationException;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorInterceptor {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<?> handleError404() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDto> handleError400(
      MethodArgumentNotValidException ex) {
    List<FieldError> errors = ex.getFieldErrors();
    return ResponseEntity.badRequest()
        .body(new ErrorDto(errors.stream().map(ArgumentNotValidError::new).collect(Collectors.toList())));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErrorDto> handleError400(HttpMessageNotReadableException ex) {
    return ResponseEntity.badRequest()
        .body(new ErrorDto("Error reading received data."));
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ErrorDto> handleErrorBadCredentials() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(new ErrorDto("Invalid credentials."));
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<ErrorDto> handleErrorAuthentication() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(new ErrorDto("Authentication failed."));
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ErrorDto> handleErrorDeniedException() {
    return ResponseEntity.status(HttpStatus.FORBIDDEN)
        .body(new ErrorDto("Access denied."));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDto> handleError500(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorDto(ex.getLocalizedMessage()));
  }

  @ExceptionHandler(IntegracaoValidationException.class)
  public ResponseEntity<ErrorDto> handleServiceValidationException(IntegracaoValidationException ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorDto(ex.getLocalizedMessage()));
  }

}
