package com.seagalputra.passport.temporaryaccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "account", timeToLive = 3600)
public class TemporaryAccount {

    @Id
    private String id;

    @Indexed
    private String email;

    private boolean isValid = false;
}
