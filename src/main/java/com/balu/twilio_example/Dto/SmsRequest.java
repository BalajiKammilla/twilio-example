package com.balu.twilio_example.Dto;
// To send a Text Message

public class SmsRequest {
    private String to;
    private String message;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
