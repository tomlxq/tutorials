package com.tom.spring.data.redis.queue;

public interface MessagePublisher {

    void publish(final String message);
}
