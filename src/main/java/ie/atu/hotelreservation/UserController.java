package ie.atu.hotelreservation;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final UserService userService;
    private PaymentServiceClient paymentServiceClient;
    private RoomReservationServiceClient roomReservationServiceClient;

    @Autowired
    public UserController (UserService userService, RoomReservationServiceClient roomReservationServiceClient, PaymentServiceClient paymentServiceClient)
    {
        this.userService = userService;
        this.paymentServiceClient = paymentServiceClient;
        this.roomReservationServiceClient = roomReservationServiceClient;
    }

    @PostMapping("/createPerson")
    public ResponseEntity<String>create(@Valid @RequestBody UserDetails userDetails) {
        userService.saveUser(userDetails);
        return new ResponseEntity<>("Person created successfully", HttpStatus.OK);
    }
    
    @GetMapping("findUser/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        if (userId.length() > 5 || userId.isBlank()) {
            return ResponseEntity.badRequest().body("User Id is invalid");
        }

        UserDetails userDetails = userService.getUserById(userId);

        if (userDetails == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDetails);
    }


    @GetMapping("deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return ResponseEntity.ok("User room cancellation complete. You have been refunded.");
    }


    @PostMapping("/book-room")
    public String bookRoom(@RequestBody @Valid UserDetails userDetails ) {

        String bookedRoom = roomReservationServiceClient.RoomConfirm(userDetails);
        String replynoti = userService.addUser(userDetails) + "\n" + bookedRoom ;
        return replynoti;


    }

    @PostMapping("/room-payment")
    public String payRoom(@RequestBody PaymentDetails paymentDetails ,UserDetails userDetails)
    {
        String paidRoom = paymentServiceClient.Payment(paymentDetails);
        String roomDetail = roomReservationServiceClient.RoomConfirm(userDetails);
        String replynoti = "You have booked room:\n" + roomDetail + "\n" + paidRoom + "\nHope you enjoy your stay";
        return replynoti;
    }



}

