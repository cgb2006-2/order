package com.heeexy.example.util;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/socket/webSocketServer/{token}")
@Component
public class WebSocket {
    private Session session;
    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    private static Map<Integer,Session> sessionPool = new HashMap<Integer,Session>();

    @OnOpen
    public void onOpen(@PathParam("token")Integer token, Session session) {
        this.session = session;
        String message ="[" + token + "]加入聊天室！！";
        // 添加到session的映射关系中
        sessionPool.put(token,session);
        // 广播通知，某用户上线了
        RemoteEndpoint.Async async  = session.getAsyncRemote ();
        async.sendText ( message );

    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for(WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息 (发送文本)
    public void sendTextMessage(@PathParam("token")Integer token, String message) {
        Session session = sessionPool.get(token);
        if (session != null) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息 (发送对象)
    public void sendObjMessage(@PathParam("token")Integer token, Object message) {
        Session session = sessionPool.get(token);
        if (session != null) {
            try {
                session.getAsyncRemote().sendObject(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

