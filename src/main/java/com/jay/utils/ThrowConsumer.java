package com.jay.utils;

@FunctionalInterface
public interface ThrowConsumer<T, E extends Exception> {
    void accept(T e) throws E;
}
