package com.java.steps.nowCoder;

import java.util.Scanner;

public class RoundCharNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double number = scanner.nextDouble();
        scanner.close();
        String str = number.toString();
        //需要进行转义
        String[] split = str.split("\\.");
        if (split[1].charAt(0) >= 53) {
            System.out.println(Integer.parseInt(split[0]) + 1);
        } else {
            System.out.println(Integer.parseInt(split[0]));
        }

    }
}
/**
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * <p>
 * 输入描述:
 * 输入一个正浮点数值
 * <p>
 * 输出描述:
 * 输出该数值的近似整数值
 * <p>
 * 示例1
 * 输入
 * 复制
 * 5.5
 * 输出
 * 复制
 * 6
 */
