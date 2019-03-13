package com.jay.socket.tomcat;

import com.google.gson.Gson;

/**
 * @ClassName SocketResult
 * @Description TODO
 * @Date 2019/3/7
 * @Author lufangjie
 * @Version 1.0
 **/     
public class SocketResult<T> {

    private String method;
    private T result;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
