package com.jay.guava.stream.event.entity;

import lombok.Value;

import java.time.Instant;
import java.util.UUID;

/**
 * @ClassName Event
 * @Description 事件的POJO类
 * @Date 2019/3/1
 * @Author lufangjie
 * @Version 1.0
 **/
@Value
public class Event {

    private final Instant created = Instant.now();
    private final int clientId;
    private final UUID uuid;
}
