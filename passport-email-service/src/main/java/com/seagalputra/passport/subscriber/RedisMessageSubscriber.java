package com.seagalputra.passport.subscriber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seagalputra.passport.api.email.request.SendEmailRequest;
import com.seagalputra.passport.email.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RedisMessageSubscriber implements MessageListener {

    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String msg = message.toString();

        try {
            SendEmailRequest sendEmailRequest = objectMapper.readValue(msg, SendEmailRequest.class);

            emailService.sendEmail(sendEmailRequest.getTo(), sendEmailRequest.getSubject(), sendEmailRequest.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
