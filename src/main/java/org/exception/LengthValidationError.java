package org.exception;

public class LengthValidationError extends RuleValidationException{
    public LengthValidationError(String message){
        super(message);
    }
}
