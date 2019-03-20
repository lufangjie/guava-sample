package com.jay.utils;

import java.util.function.Consumer;

/**
 * @ClassName FunctionalInterfaceWrapper
 * @Description TODO
 * @Date 2019/3/19
 * @Author lufangjie
 * @Version 1.0
 **/     
public class FunctionalInterfaceWrapper {

    private FunctionalInterfaceWrapper(){}

    public static <T> Consumer<T> throwingConsumerWrapper(ThrowConsumer<T, Exception> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
