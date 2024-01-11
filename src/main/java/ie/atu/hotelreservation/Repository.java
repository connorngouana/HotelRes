package ie.atu.hotelreservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface Repository extends JpaRepository<UserDetails, Long>
{

    UserDetails findByUserId(String id);

    void deleteById(Long id);


}
