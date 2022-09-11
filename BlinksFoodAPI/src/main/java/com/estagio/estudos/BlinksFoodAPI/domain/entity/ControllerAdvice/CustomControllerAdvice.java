package com.estagio.estudos.BlinksFoodAPI.domain.entity.ControllerAdvice;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.ExceptionResponse.ErrorResponse;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.ConstraitException;
import com.estagio.estudos.BlinksFoodAPI.domain.entity.exceptions.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(DataNotFoundException.class)

    public ResponseEntity <ErrorResponse> handlerNullpointerException(Exception e){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponse(httpStatus, e.getMessage()),httpStatus);
    }

    @ExceptionHandler(ConstraitException.class)
    public ResponseEntity<ErrorResponse>handlerException(Exception e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(new ErrorResponse(httpStatus, e.getMessage(), stackTrace), httpStatus);
    }


}
