package com.example.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

/**
 * @author sunhu
 * @date 2021/1/27 19:09
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel=SocketChannel.open();

        socketChannel.configureBlocking(false);
        if (!socketChannel.connect(new InetSocketAddress("127.0.0.1",6666))){
            while (!socketChannel.finishConnect()){
                System.out.println(" 未完成连接....");
            }
        }
        String str="hello world";
        ByteBuffer buffer=ByteBuffer.wrap(str.getBytes());
        socketChannel.write(buffer);


    }

}
