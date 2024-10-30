package CabBookingApplication.Repositries;
import org.springframework.data.mongodb.repository.MongoRepository;

import CabBookingApplication.Models.Admin;
public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByEmail(String email);
}

