package org.rules;

import org.exception.LengthValidationException;
import org.exception.RuleValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RuleCheck(description = "Password should be longer than 8 characters")
public class LengthRule implements Rule {
    private final boolean isDelay;
    private static final Logger log = LoggerFactory.getLogger(LengthRule.class);

    public LengthRule(boolean isDelay) {
        this.isDelay = isDelay;
    }

    @Override
    public boolean validate(String password) throws RuleValidationException {
        log.info("Checking rule:{}", name());
        simulateDelay();
        if (password != null && password.length() > 8) {
            log.debug("Passed: {}", name());
            return true;
        }
        throw new LengthValidationException("Password must be longer than 8 characters");
    }

    @Override
    public String name(){
        return "LengthRule";
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
