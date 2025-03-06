package com.balu.twilio_example.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    private final Map<String, String> otpStorage = new HashMap<>();

    public String sendOtp(String phoneNumber) {
        System.out.println("DEBUG: Sending OTP to phone number: " + phoneNumber);

        if (!phoneNumber.startsWith("+")) {
            return "Invalid phone number format. Use E.164 format (e.g., +14155552671).";
        }

        String otp = generateOtp();
        otpStorage.put(phoneNumber, otp);
        try {
            Message.creator(
                    new PhoneNumber(phoneNumber),
                    new PhoneNumber(twilioPhoneNumber),
                    "Your OTP for password reset is: " + otp
            ).create();
        }catch (Exception e){
            System.out.println("DEBUG: Twilio API Error - " + e.getMessage());
            return "Failed to send OTP: " + e.getMessage();
        }

        return "OTP sent successfully!";
    }

    public boolean verifyOtp(String phoneNumber, String otp) {
        return otpStorage.containsKey(phoneNumber) && otpStorage.get(phoneNumber).equals(otp) ;
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);  // Generates a 6-digit OTP
        return String.valueOf(otp);
    }
}
