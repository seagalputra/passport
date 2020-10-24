package com.seagalputra.passport.account;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;

public interface AccountService {
    void registerAccount(RegisterAccountRequest request);

    String testLoadBalancer();
}
