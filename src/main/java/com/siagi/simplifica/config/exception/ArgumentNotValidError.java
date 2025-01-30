package com.siagi.simplifica.config.exception;


import org.springframework.validation.FieldError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArgumentNotValidError {

  private String field;
  private String message;

  public ArgumentNotValidError(FieldError error) {
    this(error.getField(), error.getDefaultMessage());
  }

}
