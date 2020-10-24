package com.seagalputra.passport.temporaryaccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "account", timeToLive = 3600)
public class TemporaryAccount {

    private String id;
    private String email;
    private boolean isValid = false;
}
