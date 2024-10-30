package CabBookingApplication.Repositries;
//import com.example.cabbooking.models.Rider;
import org.springframework.data.mongodb.repository.MongoRepository;

import CabBookingApplication.Models.Rider;

public interface RiderRepository extends MongoRepository<Rider, String> {
    Rider findByEmail(String email);
}

