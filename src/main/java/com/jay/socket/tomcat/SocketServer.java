package com.jay.socket.tomcat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName WebSocketServer
 * @Description 基于Tomcat的Socket简单实现
 * @Date 2019/3/6
 * @Author lufangjie
 * @Version 1.0
 **/
@Slf4j
@ServerEndpoint(value = "/websocket")
@Component
public class SocketServer {

    private static CopyOnWriteArrayList<SocketServer> webSocketSet = new CopyOnWriteArrayList<>();
    private Session session;


    @OnOpen
    public void onOpen(Session session) throws IOException{
        this.session = session;
        webSocketSet.add(this);
        SocketResult<String> socketResult = new SocketResult<>();
        socketResult.setMethod("notifySystem");
        socketResult.setResult("连接成功");
        sendMessage(socketResult.toString());
    }

    /**
     * 收到客户端消息
     * @param message 客户端发送的消息
     * @param session 当前Session
     *
     **/
    @OnMessage
    public void onMessage(String message, Session session){
        log.info("来自客户端的消息：{}", message);
    }

    @OnClose
    public void onClose(Session session){
        webSocketSet.remove(this);
    }

    private void sendMessage(String message) throws IOException {
        // 向客户端发送消息
        this.session.getBasicRemote().sendText(message);
    }


}
