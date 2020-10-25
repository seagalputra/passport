package com.seagalputra.passport.account;

import com.seagalputra.passport.api.account.request.CreatePasswordRequest;
import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.passcode.request.VerifyPasscodeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody RegisterAccountRequest request) {
        accountService.registerAccount(request);
    }

    @PostMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public void verifyAccount(@RequestBody VerifyPasscodeRequest request) {
        accountService.verifyPasscode(request);
    }

    @PostMapping("/password")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPassword(@RequestBody CreatePasswordRequest request) {
        accountService.createAccountPassword(request);
    }
}
