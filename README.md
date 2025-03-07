# TWILIO

- **Twilio is a cloud based communication platform to send or receive messages and calls.**
- You can create free trail Twilio account using email.
- Once the login is done properly, Then you should able to find the **_Sid, authToken and Twilio trail phoneNumber_** as well.
- Configure the properties under your project. also create configuration class (like mapping between them) to init the Twilio.(TwilioConfig.class)
- In this project there are two example where Twilio is used.
- ## 1. Sending a random Text SMS using twilio
     -> _SmsRequest.class_

     -> _SmsService.class_

     -> _SmsController.class_
- ## 2. Sending OTP to Reset User's Password
     For Every Registration you should make the user secure with password. However, they may forget the password due to not using the account for a long time
     So, User would like to change the password or Reset with newPassword.
     Here, you should provide a functionality to change/reset the password
      However, You should verify the user with his personal information like mobileNumber by sending OTP.
     then the User could Reset the Password with newPassword.

     -> _UserEntity.class_

     -> _UserRepositoty.interface_

     -> _UserService.class_

     -> _UserController.class_

     -> _OtpRequest.class_

     -> _OtpService.class_

     **THIS WILL PROVIDE AN OTP BASED FORGETPASSWORD/CHANGE PASSWORD**
