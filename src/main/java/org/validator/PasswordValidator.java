package org.validator;

import org.exception.RuleValidationException;
import org.rules.LowerCaseRule;
import org.rules.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PasswordValidator{

    private static final Logger log = LoggerFactory.getLogger(PasswordValidator.class);
    private final List<Rule> rules;

    public PasswordValidator(List<Rule> rules){
        this.rules = rules;
    }

    /* validate method id used to validate if the password is validating all the 3 checkpoints
    along with lowercase is present or not
    @param password the password string to validate

    @throws RuleValidationException if the rules are not met
    */
    public boolean validate(String password){
        log.info("password validation is getting started");
        int passCount =0;
        boolean isLowerCase = false;

        for (Rule rule: rules){
            try{
                boolean result = rule.validate(password);
                passCount += result ? 1 : 0;
                if(rule instanceof LowerCaseRule) isLowerCase = result;
            } catch (RuleValidationException ex){
                log.warn("Failed - {} - {}", rule.name(), ex.getMessage());
            }
        }

        log.info("rules passed : {}", passCount);
        boolean finalResult = isLowerCase && passCount >=3;
        log.info("password validation: {}", finalResult ? "OK" : "NOTOK");
        return finalResult;
    }
}