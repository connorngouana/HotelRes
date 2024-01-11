package ie.atu.hotelreservation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "payment-service", url = "http://localhost:8086")
public interface PaymentServiceClient
{
    @PostMapping("/payment-confirm")
    String Payment(@RequestBody PaymentDetails paymentDetails);

}