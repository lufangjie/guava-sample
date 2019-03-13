package com.jay.socket.netty.dto;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Client
 * @Description 每个连接到socket服务的客户端对象
 * @Date 2019/3/12
 * @Author lufangjie
 * @Version 1.0
 **/
@Getter
@Setter
public class Client {

    private String id;
    private String method;
    private List<Map<String, Object>> params;
    private String version;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
