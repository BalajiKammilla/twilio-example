package com.balu.twilio_example.Resource;

import com.balu.twilio_example.Dto.SmsRequest;
import com.balu.twilio_example.Service.SmsService;
import org.springframework.web.bind.annotation.*;
// To send a Text Message

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public String sendSms(@RequestBody SmsRequest smsRequest) {
        return smsService.sendSms(smsRequest.getTo(),smsRequest.getMessage());
    }
}
