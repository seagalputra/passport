package com.seagalputra.passport.account;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.passcode.request.VerifyPasscodeRequest;

public interface AccountService {
    void registerAccount(RegisterAccountRequest request);

    void verifyPasscode(VerifyPasscodeRequest request);
}
