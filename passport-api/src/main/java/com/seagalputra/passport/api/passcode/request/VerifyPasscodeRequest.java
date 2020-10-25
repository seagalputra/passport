package com.seagalputra.passport.api.passcode.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyPasscodeRequest {
    private String email;
    private String otp;
}
