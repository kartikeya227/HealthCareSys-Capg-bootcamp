package com.cg.bootcamp.healthcare.exceptions;

public class InvalidPasswordException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidPasswordException(String string) {
        super(string);
        System.out.println("Invalid Password entered");
    }

}
