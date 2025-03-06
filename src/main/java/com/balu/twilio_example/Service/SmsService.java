package com.balu.twilio_example.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
// To send a Text Message

@Service
public class SmsService {

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    public String sendSms(String to, String messageBody) {
        Message message = Message.creator(
                new PhoneNumber(to),  // Receiver
                new PhoneNumber(twilioPhoneNumber),  // Twilio Number
                messageBody
        ).create();

        return "Message sent with SID: " + message.getSid();
    }
}
