package org.rover.application.technical.exceptions;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(String message) {
        super(message);
    }
}
