package ie.atu.hotelreservation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest
{
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserControllerIntegrationTest(MockMvc mockMvc, ObjectMapper objectMapper)
    {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;

    }

    @Test
    public void testValidUserController() throws  Exception
    {
        User validUser = new User();
        validUser.setName("Connor");
        validUser.setAge(21);
        validUser.setTitle("Mr");
        validUser.setPhone("0873493493");
        validUser.setUserId("2661");

        String requestBody = objectMapper.writeValueAsString(validUser);

    }
    @Test
    public void testInvalidUserController() throws  Exception
    {
        User InvalidUser = new User();
        InvalidUser.setName("");
        InvalidUser.setEmail("ConnorNgouana-gmail.com");
        InvalidUser.setAge(8);
        InvalidUser.setTitle("");
        InvalidUser.setPhone("-0873493493");
        InvalidUser.setUserId("");

        String requestBody = objectMapper.writeValueAsString(InvalidUser);

    }

}
