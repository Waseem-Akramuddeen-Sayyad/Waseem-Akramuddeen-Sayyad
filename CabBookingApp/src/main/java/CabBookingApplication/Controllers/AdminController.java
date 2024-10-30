package CabBookingApplication.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CabBookingApplication.Models.Admin;
import CabBookingApplication.Repositries.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminRepository adminRepository = null;

    @PostMapping("/login")
    public String adminLogin(@RequestParam String email, @RequestParam String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin == null || !admin.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        return "Admin logged in successfully";
    }
}


