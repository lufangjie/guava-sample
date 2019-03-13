package com.jay.socket.spring;

import com.google.gson.Gson;
import com.jay.socket.spring.entity.WebSocketParams;
import com.jay.socket.tomcat.SocketResult;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName WebSocketHandler
 * @Description TODO
 * @Date 2019/3/8
 * @Author lufangjie
 * @Version 1.0
 **/
public class WebSocketHandler extends TextWebSocketHandler {

    private CopyOnWriteArrayList<WebSocketSession> sessionSet = new CopyOnWriteArrayList<>();
    private WebSocketSession session;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        this.session = session;
        this.sessionSet.add(session);
        SocketResult<String> socketResult = new SocketResult<>();
        socketResult.setMethod("notifySystem");
        socketResult.setResult("连接成功");
        TextMessage textMessage = new TextMessage(socketResult.toString().getBytes());
        session.sendMessage(textMessage);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String text = message.getPayload().toString();
        Gson gson = new Gson();
        WebSocketParams params = gson.fromJson(text, WebSocketParams.class);
        System.out.println(text);
        super.handleMessage(session, message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.sessionSet.remove(session);
        super.afterConnectionClosed(session, status);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        sessionSet.remove(session);
    }


}
