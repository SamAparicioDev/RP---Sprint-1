package com.example.springwebflux.services.exceptions;

import lombok.RequiredArgsConstructor;


public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String msg){
        super(msg);
    }
}
