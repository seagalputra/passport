package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.email.request.SendEmailRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class PasscodeServiceImpl implements PasscodeService {

    private final PasscodeRepository passcodeRepository;
    private final RedisTemplate redisTemplate;
    private final ChannelTopic channelTopic;

    @Override
    public void requestPasscode(RegisterAccountRequest request) {
        String email = request.getEmail();

        passcodeRepository.findFirstByEmail(email)
                .ifPresent(passcodeRepository::delete);

        String passcode = generatePasscode();
        log.info("Generated Passcode : {}", passcode);

        Passcode requestedPasscode = Passcode.builder()
                .email(request.getEmail())
                .otp(passcode)
                .build();

        passcodeRepository.save(requestedPasscode);

        sendEmail(email, "Kode Verifikasi Anda: " + passcode);
    }

    private void sendEmail(String to, String body) {
        log.info("Sending email to: {}, body: {}", to, body);
        SendEmailRequest sendEmail = SendEmailRequest.builder()
                .to(to)
                .subject("Kode Verfikasi")
                .body(body)
                .build();

        redisTemplate.convertAndSend(channelTopic.getTopic(), sendEmail);
    }

    private String generatePasscode() {
        return new DecimalFormat("0000").format(new Random().nextInt(9999));
    }
}
