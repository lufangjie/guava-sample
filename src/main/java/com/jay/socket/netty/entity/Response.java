package com.jay.socket.netty.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Response
 * @Description TODO
 * @Date 2019/3/12
 * @Author lufangjie
 * @Version 1.0
 **/
@Getter
@Setter
public class Response<T> {

    private String method;
    private T result;

    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
