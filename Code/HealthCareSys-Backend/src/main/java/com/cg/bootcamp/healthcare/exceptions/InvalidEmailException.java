package com.cg.bootcamp.healthcare.exceptions;

public class InvalidEmailException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidEmailException(String string) {
        super(string);
    }

}