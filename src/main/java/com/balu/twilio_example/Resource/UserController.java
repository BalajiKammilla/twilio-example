package com.balu.twilio_example.Resource;

import com.balu.twilio_example.Dto.OtpRequest;
import com.balu.twilio_example.Dto.User;
import com.balu.twilio_example.Service.OtpService;
import com.balu.twilio_example.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    private final OtpService otpService;

    public UserController(UserService userService, OtpService otpService) {
        this.userService = userService;
        this.otpService = otpService;
    }

    // User Registration
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user.getPhoneNumber(), user.getPassword());
    }

    // Send OTP for Password Reset
    @PostMapping("/send-otp")
    public String sendOtp(@RequestBody Map<String, String> request) {
        String phoneNumber = request.get("phoneNumber");

        if (phoneNumber == null || !phoneNumber.matches("\\+\\d{10,15}")) {
            return "Invalid phone number format. Ensure it's in E.164 format.";
        }
        return otpService.sendOtp(phoneNumber);
    }

    @PostMapping("/check")
    public String example(@RequestBody String message){
        return "Message sent "+ message;
    }

    // Verify OTP and Reset Password
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestBody OtpRequest otpRequest) {
        if (otpService.verifyOtp(otpRequest.getPhoneNumber(), otpRequest.getOtp())) {
            boolean updated = userService.updatePassword(otpRequest.getPhoneNumber(), otpRequest.getNewPassword());
            return updated ? "Password updated successfully!" : "User not found!";
        } else {
            return "Invalid OTP!";
        }
    }
}
