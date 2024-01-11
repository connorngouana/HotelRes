package ie.atu.hotelreservation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest
{
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();
    @Test
    public void testValidUser()
    {
        User user = new User();
        user.setName("Connor");
        user.setEmail("ConnorNgouana@gmai.com");
        user.setAge(21);
        user.setTitle("Mr");
        user.setPhone("0873493493");
        user.setUserId("2661");

        assertTrue(validator.validate(user).isEmpty());
    }
    @Test
    public void testInvalidUser()
    {
        User user = new User();
        user.setName("");
        user.setEmail("ConnorNgouana-gmail.com");
        user.setAge(8);
        user.setTitle("");
        user.setPhone("-0873493493");
        user.setUserId("");

        assertEquals(6,validator.validate(user).size());
    }
}
