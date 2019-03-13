package com.jay.socket.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @ClassName WebSocketParams
 * @Description TODO
 * @Date 2019/3/8
 * @Author lufangjie
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class WebSocketParams {

    private String id;
    private String method;
    private List<Map<String, Object>> params;
    private String version;
}
