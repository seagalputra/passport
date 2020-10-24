package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class PasscodeServiceImpl implements PasscodeService {

    private final PasscodeRepository passcodeRepository;

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
    }

    private String generatePasscode() {
        return new DecimalFormat("0000").format(new Random().nextInt(9999));
    }
}
