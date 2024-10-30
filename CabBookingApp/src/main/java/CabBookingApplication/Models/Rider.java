package CabBookingApplication.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
@Data
@Document(collection = "riders")
public class Rider {
    @Id
    private String riderId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private CarDetails carDetails;

    @Data
    public static class CarDetails {
        private String carModel;
        private String licensePlate;
    }
}
