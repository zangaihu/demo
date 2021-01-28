package com.example.netty.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author sunhu
 * @date 2021/1/28 11:38
 */
public class GroupChatServer {
    public final static int port=6667;

    private Selector selector;
    private ServerSocketChannel listenChannel;

    public GroupChatServer(){

        try{

            selector=Selector.open();
            listenChannel=ServerSocketChannel.open();
            //设置非阻塞，绑定端口，注册到selector
            listenChannel.configureBlocking(false);
            listenChannel.bind(new InetSocketAddress(port));
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void listen(){
        try {
            while (true){
                int count = selector.select();
                //有事件
                if (count>0){
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        // 连接事件
                        if (key.isAcceptable()){
                            SocketChannel socketChannel = listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress()+" 上线了.....");
                        }
                        //读事件
                        if (key.isReadable()){
                            //处理
                            readData(key);
                        }
                        iterator.remove();
                    }
                }else {
                    System.out.println("无连接....等待中");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void readData(SelectionKey key){
        SocketChannel channel=null;

        try {
            //得到channel
            channel= (SocketChannel) key.channel();

            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            int count = channel.read(byteBuffer);
            if (count>0){
                String msg= new String(byteBuffer.array());
                System.out.println(channel.getRemoteAddress()+" : "+msg);
                //转发给 其他客户端,排出自己
                sendToOther(msg,channel);
            }
        }catch (Exception e){
            try {
                System.out.println(channel.getRemoteAddress()+"离线了....");
                key.cancel();
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void sendToOther(String msg,SocketChannel self) throws IOException {
        System.out.println("转发中....");

        for (SelectionKey key : selector.keys()) {

            Channel targetChannel = key.channel();

            if (targetChannel instanceof SocketChannel && targetChannel!=self){
                SocketChannel destChannel = (SocketChannel) targetChannel;

                ByteBuffer byteBuffer=ByteBuffer.wrap(msg.getBytes());

                destChannel.write(byteBuffer);
            }
        }

    }


    public static void main(String[] args) {
        GroupChatServer groupChatServer=new GroupChatServer();
        groupChatServer.listen();
    }
}
