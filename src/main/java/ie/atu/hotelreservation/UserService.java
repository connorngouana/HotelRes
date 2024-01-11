package ie.atu.hotelreservation;

import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService
{
    private final Repository repository;

    public UserService(Repository repository){
        this.repository = repository;
    }


    public String addUser( @Valid UserDetails userDetails)
    {

        String hotelUserDetails = "Title: " + userDetails.getTitle() + "\nName: " + userDetails.getName() + "\nEmail: " + userDetails.getEmail()
                + "\nPhone: " + userDetails.getPhone()  + "\nID: " + userDetails.getId()  + "\nage: " + userDetails.getAge();
        return hotelUserDetails;
    }

    public void saveUser(UserDetails userDetails)
    {
        repository.save(userDetails);
    }

    public UserDetails getUserById(String userid)
    {
        return repository.findByUserId(userid);
    }

    public void deleteUser(Long id)
    {
        repository.deleteById(id);

    }



}
