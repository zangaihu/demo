package com.example.copy.deepcopy;

import java.io.*;

/**
 * 字节流序列化，反序列化实现深拷贝
 * @author sunhu
 * @date 2020/12/31 10:19
 */
public class CloneUtil {

    public static <T extends Serializable> T clone(T obj){
        T cloneObj=null;

        try {
            // 写入字节流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(byteArrayOutputStream);
            obs.writeObject(obj);
            obs.close();

            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            cloneObj= (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cloneObj;
    }
}
