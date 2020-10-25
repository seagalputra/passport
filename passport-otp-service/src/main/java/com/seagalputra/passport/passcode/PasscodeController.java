package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.passcode.request.VerifyPasscodeRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Slf4j
public class PasscodeController {

    private final PasscodeService passcodeService;

    @PostMapping("/passcodes")
    @ResponseStatus(HttpStatus.OK)
    public void requestPasscode(@RequestBody RegisterAccountRequest request) {
        passcodeService.requestPasscode(request);
    }

    @PostMapping("/passcodes/verify")
    public void verifyPasscode(@RequestBody VerifyPasscodeRequest request) {
        passcodeService.verifyPasscode(request);
    }
}
