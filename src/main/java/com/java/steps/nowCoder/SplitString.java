package com.java.steps.nowCoder;

import java.util.Scanner;

public class SplitString {
    public void splitString(String str) {
        int rest = str.length() % 8;
        int times = str.length() / 8;
        if (times == 0) {
            for (int i = 0; i < 8 - rest; i++) {
                str += "0";
            }
            System.out.println(str);
        } else {
            for (int i = 0; i < times; i++) {
                System.out.println(str.substring(8 * i, 8 * (i + 1)));
            }
            if (rest != 0) {
                String left = str.substring(str.length() - rest, str.length());
                for (int i = 0; i < 8 - rest; i++) {
                    left += "0";
                }
                System.out.println(left);
            }
        }
    }

    public static void main(String[] args) {
        SplitString main = new SplitString();
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String str2 = input.nextLine();
        main.splitString(str1);
        main.splitString(str2);
    }
}

//题目描述
//        •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
//        •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
//        输入描述:
//        连续输入字符串(输入2次,每个字符串长度小于100)
//
//        输出描述:
//        输出到长度为8的新字符串数组
