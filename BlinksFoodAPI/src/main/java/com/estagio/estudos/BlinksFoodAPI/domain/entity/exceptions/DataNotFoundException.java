package com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions;

public class DataNotFoundException extends  RuntimeException{

    public DataNotFoundException(){
        super();
    }
    public DataNotFoundException(String message){
        super(message);
    }

}
