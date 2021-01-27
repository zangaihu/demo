package com.example.netty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sunhu
 * @date 2021/1/27 10:22
 */
public class NIOFileChannel01 {

    public static void main(String[] args) throws IOException {
        String str="hello worlxxxxxx";
        //创建一个输出流-》channel
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\nettydemo.txt");

        //获取channel
        FileChannel channel = fileOutputStream.getChannel();

        // 字节缓冲区，分配大小
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        //写入buffer
        byteBuffer.put(str.getBytes());
        //flip 读写转换
        byteBuffer.flip();
        //写入channel
        channel.write(byteBuffer);

        fileOutputStream.close();
    }

}
