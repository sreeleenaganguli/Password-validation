package org.rules;

import org.exception.RuleValidationException;

public interface Rule {
    boolean validate(String password) throws RuleValidationException;
    String name();

}
