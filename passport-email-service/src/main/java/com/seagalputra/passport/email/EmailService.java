package com.seagalputra.passport.email;

public interface EmailService {

    void sendEmail(String to, String subject, String body);
}
