package com.seagalputra.passport.passcode;

import com.seagalputra.passport.api.account.request.RegisterAccountRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Slf4j
public class PasscodeController {

    private final PasscodeService passcodeService;
    private final Environment environment;

    @PostMapping("/passcodes")
    @ResponseStatus(HttpStatus.OK)
    public void requestPasscode(@RequestBody RegisterAccountRequest request) {
        passcodeService.requestPasscode(request);
    }

    @GetMapping("/passcodes/port")
    public String checkPort() {
        String port = environment.getProperty("local.server.port");
        log.info("Port => {}", port);

        return "OK with port: " + port;
    }
}
