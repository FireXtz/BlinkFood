package com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public AddressException(String msg) {
		super(msg);
	}
}
