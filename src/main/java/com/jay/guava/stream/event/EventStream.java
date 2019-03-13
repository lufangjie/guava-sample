package com.jay.guava.stream.event;

/**
 * @ClassName EventStream
 * @Description TODO
 * @Date 2019/3/1
 * @Author lufangjie
 * @Version 1.0
 **/     
public interface EventStream {

    void consumer(EventConsumer consumer);
}
