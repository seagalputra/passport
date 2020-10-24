package com.seagalputra.passport.client;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "passcode", url = "http://127.0.0.1:8020")
public interface PasscodeClient {

    @PostMapping("/v1/passcodes")
    void requestPasscode(@RequestBody RegisterAccountRequest request);
}
