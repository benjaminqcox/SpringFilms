package com.bootcamp.learningSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="No film found using the provided parameters.")
public class FilmNotFoundException extends RuntimeException{
    public FilmNotFoundException() {}

    public FilmNotFoundException(String message) {
        super(message);
    }
}
