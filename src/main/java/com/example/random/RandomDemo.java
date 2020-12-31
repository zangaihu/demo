package com.example.random;

import java.text.DecimalFormat;

/**
 * @author sunhu
 * @date 2020/12/29 11:42
 */
public class RandomDemo {

    public static void main(String[] args) {

        int i = randomNumber();
        System.out.println(i);
    }

    public static int randomNumber() {
        int[] array = {70, 20, 5, 5};
        DecimalFormat df = new DecimalFormat("######0.00");
        int random = -1;
        try {
            //计算总权重
            double sumWeight = 0;
            for (int p : array) {
                sumWeight += p;
            }

            //产生随机数
            double randomNumber;
            randomNumber = Math.random();

            //根据随机数在所有数字分布的区域来确定随机选取的数字
            double d1 = 0;
            double d2 = 0;
            for (int i = 0; i < array.length; i++) {
                d2 += Double.parseDouble(String.valueOf(array[i])) / sumWeight;
                if (i == 0) {
                    d1 = 0;
                } else {
                    d1 += Double.parseDouble(String.valueOf(array[i - 1])) / sumWeight;
                }
                if (randomNumber >= d1 && randomNumber <= d2) {
                    random = i + 1;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("流量统计--生成概率随机乘客数出错，出错原因：" + e.getMessage());
        }
        return random;
    }
}
