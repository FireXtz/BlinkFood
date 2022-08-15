package com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class KitchenNotFoundException extends RuntimeException{
    private final Long SerialVersionUID = 1L;

    public KitchenNotFoundException (String message){
        super(message);
    }

}
