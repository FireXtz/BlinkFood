package com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions;

import org.springframework.dao.DataIntegrityViolationException;



public class EntityUsedException extends DataIntegrityViolationException {
    private final long serialVersionUID = 1L;
    public EntityUsedException (String message){
       super(message);
    }
}
