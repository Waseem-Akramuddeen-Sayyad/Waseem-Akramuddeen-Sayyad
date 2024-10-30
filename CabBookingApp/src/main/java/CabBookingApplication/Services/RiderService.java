package CabBookingApplication.Services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import CabBookingApplication.Models.Rider;
import CabBookingApplication.Repositries.RiderRepository;
import java.util.Collections;

@Service
public class RiderService implements UserDetailsService {
    private final RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Rider rider = riderRepository.findByEmail(email);
        if (rider == null) {
            throw new UsernameNotFoundException("Rider not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(rider.getEmail())
                .password(rider.getPassword())
                .authorities(Collections.emptyList()) // Add roles if needed
                .build();
    }
}

