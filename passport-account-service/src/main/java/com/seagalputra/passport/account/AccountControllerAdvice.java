package com.seagalputra.passport.account;

import com.seagalputra.passport.api.exception.AlreadyRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccountControllerAdvice {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyRegisteredException.class)
    private void alreadyRegisteredException() {
    }
}
