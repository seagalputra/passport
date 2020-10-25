package com.seagalputra.passport.account;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.passcode.request.VerifyPasscodeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody RegisterAccountRequest request) {
        accountService.registerAccount(request);
    }

    @PostMapping("/accounts/verify")
    @ResponseStatus(HttpStatus.OK)
    public void verifyAccount(@RequestBody VerifyPasscodeRequest request) {
        accountService.verifyPasscode(request);
    }
}
