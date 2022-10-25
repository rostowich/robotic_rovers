package org.rover.domain.services.evaluation.exceptions;

public class OutOfThePlateauException extends Exception{

    private String message;

    public OutOfThePlateauException(String message) {
        super(message);
    }
}
