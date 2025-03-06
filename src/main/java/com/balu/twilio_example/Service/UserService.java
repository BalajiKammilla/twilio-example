package com.balu.twilio_example.Service;

import com.balu.twilio_example.Dto.User;
import com.balu.twilio_example.Repo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(String phoneNumber, String password) {
        if (userRepository.existsById(phoneNumber)) {
            return "User already registered!";
        }
        userRepository.save(new User(phoneNumber, password));
        return "User registered successfully!";
    }

    public boolean updatePassword(String phoneNumber, String newPassword) {
        Optional<User> userOptional = userRepository.findById(phoneNumber);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
