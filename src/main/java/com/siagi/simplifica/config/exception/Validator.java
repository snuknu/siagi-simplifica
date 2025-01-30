package com.siagi.simplifica.config.exception;

public interface Validator<T> {
  public void validate(T dto);
}
