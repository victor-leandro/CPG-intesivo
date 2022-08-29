package com.exercicio.exception;

import io.micronaut.http.HttpStatus;

public class MenorIdadeExeption extends Exception{
    public MenorIdadeExeption(String message) {
        super(message);
    }
}
