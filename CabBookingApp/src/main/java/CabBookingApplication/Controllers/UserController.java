package CabBookingApplication.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CabBookingApplication.Models.User;
import CabBookingApplication.Repositries.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    @PostMapping("/")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/profile/{userId}")
    public User updateUserProfile(@PathVariable String userId, @RequestBody User updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(updatedUser.getName());
        user.setPhone(updatedUser.getPhone());
        return userRepository.save(user);
    }
}

