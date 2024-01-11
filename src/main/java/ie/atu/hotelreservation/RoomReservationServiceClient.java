package ie.atu.hotelreservation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "room-confirm", url = "http://localhost:8085")
public interface RoomReservationServiceClient
{
    @PostMapping("/room-confirm")
    String RoomConfirm(@RequestBody UserDetails userDetails);


}

