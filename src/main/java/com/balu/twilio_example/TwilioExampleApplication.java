package com.balu.twilio_example;

import com.balu.twilio_example.Config.TwilioConfig;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioExampleApplication {

public static void main(String[] args) {
		SpringApplication.run(TwilioExampleApplication.class, args);
	}

}
