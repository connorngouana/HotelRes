package ie.atu.hotelreservation;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "reservation-service", url ="http://localhost:8084")
public interface HotelReservationServiceClient {

    @PostMapping("/Reservationconfirm")
    String ReservationDetails(@RequestBody UserDetails userDetails);
}
