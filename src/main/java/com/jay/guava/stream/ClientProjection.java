package com.jay.guava.stream;

import com.jay.guava.stream.event.EventConsumer;
import com.jay.guava.stream.event.entity.Event;

/**
 * @ClassName ClientProjection
 * @Description TODO
 * @Date 2019/3/1
 * @Author lufangjie
 * @Version 1.0
 **/     
public class ClientProjection implements EventConsumer {

    @Override
    public Event consumer(Event event) {
        // 用睡眠替代实际的一些耗时操作
        Sleeper.randSleep(10, 1);
        return event;
    }
}
