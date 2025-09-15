import org.Exception.PasswordValidationException;
import org.Validator.PasswordValidator;
import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void validPassword(){
        assertDoesNotThrow(() -> validator.validate("StrongPwd@1"));
    }

    @Test
    void invalidPasswordnull(){
        Exception ex = assertThrows(PasswordValidationException.class, () -> validator.validate(null));
        assertTrue(ex.getMessage().contains("null"));
    }

    @Test
    void invalidPasswordnolowercase(){
        Exception ex = assertThrows(PasswordValidationException.class, () -> validator.validate("ABCDEF!1"));
        assertTrue(ex.getMessage().toLowerCase().contains("lowercase"));
    }

    @Test
    void invalidPasswordnouppercase(){
        Exception ex = assertThrows(PasswordValidationException.class, () -> validator.validate("#absdfgh1"));
        assertTrue(ex.getMessage().contains("uppercase"));
    }

    @Test
    void invalidPasswordnospecialchar(){
        Exception ex = assertThrows(PasswordValidationException.class, () -> validator.validate("Abdfrfd45"));
        assertTrue(ex.getMessage().contains("Password needs to have at least one special character"));
    }
}
