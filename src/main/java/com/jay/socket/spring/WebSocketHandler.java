package com.jay.socket.spring;

import com.jay.socket.tomcat.SocketResult;
import com.jay.utils.FunctionalInterfaceWrapper;
import org.springframework.web.socket.*;
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

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(session.getId());
        super.afterConnectionEstablished(session);
        this.sessionSet.add(session);
        SocketResult<String> socketResult = new SocketResult<>();
        socketResult.setMethod("notifySystem");
        socketResult.setResult("连接成功");
        TextMessage textMessage = new TextMessage(socketResult.toString().getBytes());
        session.sendMessage(textMessage);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        String text = message.getPayload();
        System.out.println(text);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {

    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.sessionSet.remove(session);
        super.afterConnectionClosed(session, status);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        sessionSet.remove(session);
    }

    public void sendMessageForAll(String message) {
        this.sessionSet.forEach(
                FunctionalInterfaceWrapper.throwingConsumerWrapper(session -> {
                    TextMessage textMessage = new TextMessage(message);
                    session.sendMessage(textMessage);
                }));
    }
}
