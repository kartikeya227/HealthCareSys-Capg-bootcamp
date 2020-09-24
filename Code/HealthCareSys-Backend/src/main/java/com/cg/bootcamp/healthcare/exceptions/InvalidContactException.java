package com.cg.bootcamp.healthcare.exceptions;

public class InvalidContactException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidContactException(String string) {
        super(string);
    }

}