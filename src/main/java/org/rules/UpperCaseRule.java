package org.rules;

import org.exception.LowerCaseValidationException;
import org.exception.RuleValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RuleCheck(description = "Password should have at least one uppercase.")
public class UpperCaseRule implements Rule{
    private static final Logger log = LoggerFactory.getLogger(UpperCaseRule.class);
    public final boolean isDelay;

    public UpperCaseRule(boolean isDelay) {
        this.isDelay = isDelay;
    }

    @Override
    public boolean validate(String password) throws RuleValidationException {
        log.info("Checking rule:{}", name());
        simulateDelay();
        if (password != null && password.chars().anyMatch(Character::isUpperCase)) {
            log.debug("Passed: {}", name());
            return true;
        }
        throw new LowerCaseValidationException("Password should have at least one Uppercase letter");
    }

    @Override
    public String name(){
        return "UpperCaseRule";
    }

    private void simulateDelay(){
        if (isDelay){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
