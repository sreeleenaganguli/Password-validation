package org.Validator;

import org.Exception.PasswordValidationException;

import java.util.concurrent.TimeUnit;

public class PasswordValidator{
    private void simulateDelay(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException ignored){}
    }
        public void validate(String password) throws PasswordValidationException{
            int passedRules = 0;
            boolean hasLowercase = false;

            simulateDelay();
            if(password == null){
                throw new PasswordValidationException("Password cannot be null");
            } else {
                passedRules++;
            }

            simulateDelay();
            if(password.length() < 8){
                throw new PasswordValidationException("Password cannot be less than 8 characters");
            } else {
                passedRules++;
            }

            simulateDelay();
            if(password.chars().anyMatch(Character::isUpperCase)){
                passedRules++;
            } else {
                throw new PasswordValidationException("Password needs to have one uppercase");
            }

            simulateDelay();
            if(password.chars().anyMatch(Character::isLowerCase)){
                passedRules++;
                hasLowercase = true;
            } else {
                throw new PasswordValidationException("Password needs to have one lowercase");
            }

            simulateDelay();
            if(password.chars().anyMatch(Character::isDigit)){
                passedRules++;
            } else {
                throw new PasswordValidationException("Password needs to have at least one digit");
            }

            simulateDelay();
            if(password.chars().anyMatch(ch -> "!@#$%^&*(_-{}|[];:,.?\"/".indexOf(ch) >= 0)){
                passedRules++;
            }else {
                throw new PasswordValidationException("Password needs to have at least one special character");
            }

            if (passedRules < 3){
                throw new PasswordValidationException("Password must contain at least 4 characters");
            }
        }
}