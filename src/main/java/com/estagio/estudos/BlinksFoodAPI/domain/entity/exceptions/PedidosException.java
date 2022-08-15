package com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidosException extends RuntimeException{
    private final long serialVersionUID = 1L;

    public PedidosException(Long id){
        super("Não Foi possivel achar o pedido de id:"+id);
    }
}
