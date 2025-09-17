package org.rules;

import org.exception.LowerCaseValidationError;
import org.exception.RuleValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigitRule implements Rule{
    private static final Logger log = LoggerFactory.getLogger(DigitRule.class);
    public final boolean isDelay;

    public DigitRule(boolean isDelay) {
        this.isDelay = isDelay;
    }

    @Override
    public boolean validate(String password) throws RuleValidationException {
        log.info("Checking rule:{}", name());
        simulateDelay();
        if (password != null && password.chars().anyMatch(Character::isDigit)) {
            log.debug("Passed: {}", name());
            return true;
        }
        throw new LowerCaseValidationError("Password should have at least one digit");
    }

    @Override
    public String name(){
        return "LowerCaseRule";
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
