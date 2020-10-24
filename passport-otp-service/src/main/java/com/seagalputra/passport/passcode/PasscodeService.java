package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;

public interface PasscodeService {
    void requestPasscode(RegisterAccountRequest request);
}
