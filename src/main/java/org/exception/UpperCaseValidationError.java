package org.exception;

public class UpperCaseValidationError extends Exception{
    public UpperCaseValidationError(String message){
        super("Password should have at least one Uppercase letter");
    }
}

