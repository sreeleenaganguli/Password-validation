package org;

import org.validator.PasswordValidator;
import org.rules.LengthRule;
import org.rules.LowerCaseRule;
import org.rules.Rule;
import org.rules.UpperCaseRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<Rule> rules = Arrays.asList(
                new LengthRule(true),
                new DigitRule(true),
                new LowerCaseRule(true),
                new UpperCaseRule(true)
        );

        PasswordValidator validator = new PasswordValidator(rules);
        try(Scanner scanner = new Scanner(System.in)){
            while(true){
                System.out.print("Enter a password to validate (or 'exit' to quit): ");
                String input = scanner.nextLine();
                if("exit".equalsIgnoreCase(input)) break;
                boolean valid = validator.validate(input);
                System.out.println(valid ? "Password OK" : "Password not Ok");
            }
        }
    }
}
