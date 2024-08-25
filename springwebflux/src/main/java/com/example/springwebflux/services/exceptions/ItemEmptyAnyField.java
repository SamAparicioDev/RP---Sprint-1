package com.example.springwebflux.services.exceptions;

public class ItemEmptyAnyField extends RuntimeException {
    public ItemEmptyAnyField(String msg) {
        super(msg);
    }
}
