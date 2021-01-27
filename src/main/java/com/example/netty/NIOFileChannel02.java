package com.example.netty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sunhu
 * @date 2021/1/27 10:39
 */
public class NIOFileChannel02 {

    public static void main(String[] args) throws IOException {



        //创建输入流，获取channel
        File file=new File("D:\\nettydemo.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        //写入buffer，
        channel.read(buffer);

        System.out.println(new String(buffer.array()));
        fileInputStream.close();
    }
}
