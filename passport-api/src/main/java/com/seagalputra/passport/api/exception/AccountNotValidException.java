package com.seagalputra.passport.api.exception;

public class AccountNotValidException extends RuntimeException {
    public AccountNotValidException(String message) {
        super(message);
    }
}
