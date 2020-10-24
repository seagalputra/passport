package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class PasscodeController {

    private final PasscodeService passcodeService;

    @PostMapping("/passcodes")
    @ResponseStatus(HttpStatus.OK)
    public void requestPasscode(@RequestBody RegisterAccountRequest request) {
        passcodeService.requestPasscode(request);
    }
}
