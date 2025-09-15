package org;

import org.Exception.PasswordValidationException;
import org.Validator.PasswordValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        String[] passwords = {
                "Abc12345",
                "ABCDEFGH",
                "abc",
                "Password1",
                "123456789"
        };

        for(String pwd: passwords){
            try{
                validator.validate(pwd);
                log.info("OK:" + pwd);
            } catch(PasswordValidationException e){
                log.info("Invalid" + pwd + ":" + e.getMessage());
            }
        }
    }
}