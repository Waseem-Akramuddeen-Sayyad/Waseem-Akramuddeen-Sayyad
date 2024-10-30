package CabBookingApplication.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CabBookingApplication.Models.Rider;
import CabBookingApplication.Repositries.RiderRepository;

@RestController
@RequestMapping("/rider")
public class RiderController {
    private final RiderRepository riderRepository = null;

    @PostMapping("/")
    public Rider registerRider(@RequestBody Rider rider) {
        return riderRepository.save(rider);
    }

    @PutMapping("/profile/{riderId}")
    public Rider updateRiderProfile(@PathVariable String riderId, @RequestBody Rider updatedRider) {
        Rider rider = riderRepository.findById(riderId).orElseThrow(() -> new RuntimeException("Rider not found"));
        rider.setName(updatedRider.getName());
        return riderRepository.save(rider);
    }
}

