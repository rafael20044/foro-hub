package com.forohub.forohub.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadoDeErrores {

    @ExceptionHandler(FindException.class)
    public ResponseEntity errorNoEncontrado(FindException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
