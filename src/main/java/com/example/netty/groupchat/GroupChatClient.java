package com.example.netty.groupchat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 群聊客户端
 * @author sunhu
 * @date 2021/1/28 14:10
 */
public class GroupChatClient {

    private String host="127.0.0.1";
    private int port=6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;



    public GroupChatClient(){

        try {
            selector=Selector.open();
            socketChannel=SocketChannel.open(new InetSocketAddress(host,port));
            //绑定端口，注册到selector

            socketChannel.configureBlocking(false);

            socketChannel.register(selector, SelectionKey.OP_READ);
            userName=socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(userName+"is ok....");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void sendInfo(String info){
//        info=userName +" 说： "+info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        }catch (Exception e){

        }
    }

    public void readInfo(){
        try {

            int readChannels = selector.select();
            if (readChannels>0){

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();

                    if (key.isReadable()){
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                        channel.read(byteBuffer);
                        String msg = new String(byteBuffer.array());
                        System.out.println(channel.getRemoteAddress()+":"+msg.trim());
                    }
                    iterator.remove();
                }
            }
        }catch (Exception e){

        }
    }


    public static void main(String[] args) {
        GroupChatClient groupChatClient=new GroupChatClient();

        new Thread(() -> {
            while (true){
                groupChatClient.readInfo();
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner=new Scanner(System.in);

        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            groupChatClient.sendInfo(s);
        }

    }
}
