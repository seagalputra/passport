package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.passcode.request.VerifyPasscodeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "otp")
public interface PasscodeClient {

    @PostMapping("/v1/passcodes")
    void requestPasscode(@RequestBody RegisterAccountRequest request);

    @PostMapping("/v1/passcodes/verify")
    void verifyPasscode(@RequestBody VerifyPasscodeRequest request);
}
