package org.exception;

public class DigitValidationError extends RuleValidationException{
    public DigitValidationError(String message){
        super("Password should have at least one digit");
    }
}