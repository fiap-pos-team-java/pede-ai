package com.pede.ai.core.exceptions;

public class NotFoundException extends DomainGlobalException{

  public NotFoundException(String errorMessage) {
    super(errorMessage);
  }

}
