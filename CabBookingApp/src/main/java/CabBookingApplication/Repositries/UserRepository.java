package CabBookingApplication.Repositries;
import org.springframework.data.mongodb.repository.MongoRepository;
import CabBookingApplication.Models.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}