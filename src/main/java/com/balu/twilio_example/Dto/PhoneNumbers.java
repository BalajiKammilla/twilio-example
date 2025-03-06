package com.balu.twilio_example.Dto;

public class PhoneNumbers {

    private  String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumbers{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
