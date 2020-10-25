package com.seagalputra.passport.passcode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "otp", timeToLive = 300)
public class Passcode {

    private String id;

    private String otp;

    @Indexed
    private String email;
}
