package ie.atu.hotelreservation;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Title is required")
    private String title;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @Positive(message = "Phone number must be positive")
    private String Phone;

    @NotBlank(message = "userId is required")
    private String userId;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PaymentDetails
    {

        private double lengthOfStay;

        private double roomRate;

        private double taxRate;


        private double total;
    }


}

