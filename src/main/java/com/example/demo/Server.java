package com.example.demo;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunhu
 * @date 2020/9/25 13:58
 */
public class Server {
    private static ConcurrentHashMap<String, Server> webSocketMap = new ConcurrentHashMap<>();
    private String id="";


    public void add(){
        this.id= UUID.randomUUID().toString();
        webSocketMap.put(id,this);

    }

    public void open(){
        for (int i = 0; i < 5; i++) {
            add();
        }
    }

    public void close(){
        Iterator<Map.Entry<String, Server>> entries = Server.webSocketMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Server> next = entries.next();
            Server server = next.getValue();
            System.out.println(server.id);
        }
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.open();
        server.close();
    }
}
