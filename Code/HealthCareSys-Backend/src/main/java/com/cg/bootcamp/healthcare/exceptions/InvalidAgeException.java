package com.cg.bootcamp.healthcare.exceptions;

public class InvalidAgeException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidAgeException(String string) {
        super(string);
    }

}
