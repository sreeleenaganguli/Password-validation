import org.validator.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import org.rules.LengthRule;
import org.rules.LowerCaseRule;
import org.rules.UpperCaseRule;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/* unit tests for {@link PasswordValidator}
    Covers all edge cases and rule combinations
* */
public class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp(){
        validator = new PasswordValidator(Arrays.asList(
                new LengthRule(false),
                new UpperCaseRule(false),
                new LowerCaseRule(false),
                new UpperCaseRule(false)
        ));
    }

    @Test
    void validPassword(){
        assertTrue(validator.validate("Gmail1256h"));
    }

    @Test
    void invalidPasswordnull(){
        assertFalse(validator.validate(null));
    }

    @Test
    void invalidPasswordnolowercase(){
         assertFalse(validator.validate("ABCDEF1"));
    }

    @Test
    void invalidPasswordnouppercase(){
         assertFalse(validator.validate("hgbsdfgh1"));
    }

    @Test
    void invalidPasswordlength(){
        assertFalse(validator.validate("Ad45"));
    }
}
