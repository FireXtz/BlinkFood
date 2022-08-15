package com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StatesNotFoundException extends RuntimeException {
   private final long serialVersionUID = 1L;
   public StatesNotFoundException(String message){
       super(message);
   }
}
