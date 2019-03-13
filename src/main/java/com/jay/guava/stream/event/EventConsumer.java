package com.jay.guava.stream.event;

import com.jay.guava.stream.event.entity.Event;

/**
 * @ClassName EventConsumer
 * @Description 事件的消费者
 * @Date 2019/3/1
 * @Author lufangjie
 * @Version 1.0
 **/
@FunctionalInterface
public interface EventConsumer {
    Event consumer(Event event);
}
