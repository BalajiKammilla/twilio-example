package com.balu.twilio_example.Dto;

public class OtpRequest {

    private String phoneNumber;
    private String otp;
    private String newPassword;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "OtpRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", otp='" + otp + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
