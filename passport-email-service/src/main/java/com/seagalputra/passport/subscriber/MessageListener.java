package com.seagalputra.passport.subscriber;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@AllArgsConstructor
public class MessageListener {

    private final RedisMessageSubscriber redisMessageSubscriber;

    @Bean
    public org.springframework.data.redis.connection.MessageListener messageListenerAdapter() {
        return new MessageListenerAdapter(redisMessageSubscriber);
    }
}
