package com.java.steps.nowCoder;

import java.util.Scanner;

import static java.lang.Math.pow;

public class BinaryConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char tmp = ' ';
        int count = 0;
        String str = input.nextLine();
        while (str != null) {
            str = str.substring(2).toUpperCase();
            for (int i = 0; i < str.length(); i++) {
                tmp = str.charAt(str.length() - 1 - i);
                if (tmp < 65) {
                    int a = tmp - 48;
                    count += a * pow(16, i);
                } else {
                    int a = tmp - 55;
                    count += a * pow(16, i);
                }
            }
            System.out.println(Integer.toString(count));
            count = 0;
            str = input.nextLine();
        }
        input.close();
    }
}
/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 * <p>
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * <p>
 * 输出描述:
 * 输出该数值的十进制字符串。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 0xA
 * 输出
 * 复制
 * 10
 */
