package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "otp")
public interface PasscodeClient {

    @PostMapping("/v1/passcodes")
    void requestPasscode(@RequestBody RegisterAccountRequest request);

    @GetMapping("/v1/passcodes/port")
    String checkPort();
}
