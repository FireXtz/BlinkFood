package com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions;

public class ConstraitException extends  RuntimeException {

    public ConstraitException(){
        super();
    }

    public ConstraitException(String message){
        super(message);
    }


}
