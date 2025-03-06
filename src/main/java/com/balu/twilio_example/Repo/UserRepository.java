package com.balu.twilio_example.Repo;

import com.balu.twilio_example.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByPhoneNumber(String phoneNumber);
}
