package com.seagalputra.passport.subscriber;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@AllArgsConstructor
public class MessageListener {

    private final RedisMessageSubscriber redisMessageSubscriber;
    private final LettuceConnectionFactory connectionFactory;
    private final ChannelTopic channelTopic;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        org.springframework.data.redis.connection.MessageListener listener = new MessageListenerAdapter(redisMessageSubscriber);

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listener, channelTopic);
        return container;
    }
}
