package com.example.springwebflux.exceptions;

import com.example.springwebflux.services.exceptions.ItemEmptyAnyField;
import com.example.springwebflux.services.exceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(ItemNotFoundException.class)
    public Mono<ResponseEntity<String>> exceptionHandlerItemNotFound(ItemNotFoundException e){
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()));
    }
    @ExceptionHandler(ItemEmptyAnyField.class)
    public Mono<ResponseEntity<String>> exceptionHandlerItemEmptyAnyField(ItemEmptyAnyField e){
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()));
    }
}
