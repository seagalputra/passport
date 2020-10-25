package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.passcode.request.VerifyPasscodeRequest;

public interface PasscodeService {
    void requestPasscode(RegisterAccountRequest request);

    void verifyPasscode(VerifyPasscodeRequest request);
}
