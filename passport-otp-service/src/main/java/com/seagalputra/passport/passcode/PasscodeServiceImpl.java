package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.email.request.SendEmailRequest;
import com.seagalputra.passport.api.exception.NotFoundException;
import com.seagalputra.passport.api.exception.NotMatchException;
import com.seagalputra.passport.api.passcode.request.VerifyPasscodeRequest;
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

    @Override
    public void verifyPasscode(VerifyPasscodeRequest request) {

        String email = request.getEmail();

        Passcode passcode = passcodeRepository.findFirstByEmail(email)
                .orElseThrow(() -> new NotFoundException("Email " + email + " not found!"));

        if (!passcode.getOtp().equals(request.getOtp())) throw new NotMatchException("Passcode doesn't match!");
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
