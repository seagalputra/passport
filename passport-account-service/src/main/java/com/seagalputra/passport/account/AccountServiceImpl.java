package com.seagalputra.passport.account;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import com.seagalputra.passport.api.exception.AlreadyRegisteredException;
import com.seagalputra.passport.passcode.PasscodeClient;
import com.seagalputra.passport.temporaryaccount.TemporaryAccount;
import com.seagalputra.passport.temporaryaccount.TemporaryAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TemporaryAccountRepository temporaryAccountRepository;
    private final PasscodeClient passcodeClient;

    @Override
    public void registerAccount(RegisterAccountRequest request) {
        String email = request.getEmail();

        accountRepository.findFirstByEmail(email)
                .ifPresent(account -> {
                    throw new AlreadyRegisteredException("User " + account.getEmail() + "already registered!");
                });

        TemporaryAccount temporaryAccount = temporaryAccountRepository.findFirstByEmail(email)
                .orElse(TemporaryAccount.builder().build());

        temporaryAccount.setEmail(email);
        temporaryAccount.setValid(false);
        temporaryAccountRepository.save(temporaryAccount);

        passcodeClient.requestPasscode(request);
    }
}
