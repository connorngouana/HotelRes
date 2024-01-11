package ie.atu.hotelreservation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails
{

    private double lengthOfStay;

    private double roomRate;

    private double taxRate;


    private double total;
}
