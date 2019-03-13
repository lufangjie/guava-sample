package com.jay.socket.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @ClassName SocketConfigurator
 * @Description 基于spring的TextWebSocketHandler的简单实现
 *              配置websocket的入口，允许访问的域、注册的handler、SockJS的支持和拦截器
 * @Date 2019/3/8
 * @Author lufangjie
 * @Version 1.0
 **/
@Configuration
@EnableWebSocket
public class SocketConfigurator implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/websocket").setAllowedOrigins("*").addInterceptors(handShakeInterceptor());
        // 支持SockJS
//        registry.addHandler(webSocketHandler(), "/websocket").setAllowedOrigins("*").addInterceptors(handShakeInterceptor()).withSockJS();
    }

    @Bean
    public WebSocketHandler webSocketHandler(){
        return new WebSocketHandler();
    }

    @Bean
    public HandShakeInterceptor handShakeInterceptor(){
        return new HandShakeInterceptor();
    }
}
