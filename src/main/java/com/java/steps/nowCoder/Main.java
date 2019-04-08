package com.java.steps.nowCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        String[] str = string.split(" ");
        int size = Integer.parseInt(str[0]);
        int mergeNum = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        if (size != 0 && str.length == 1) {
            System.out.println("输入异常！");
        } else {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 1; i <= size * 2 - 1; i = i + 2) {
                tmp1 = Integer.parseInt(str[i]);
                tmp2 = Integer.parseInt(str[i + 1]);
                if (map.get(tmp1) == null) {
                    map.put(tmp1, tmp2);
                } else {
                    mergeNum = map.get(tmp1);
                    mergeNum += tmp2;
                    map.put(tmp1, mergeNum);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()
            ) {
                System.out.print(entry.getKey() + " " + entry.getValue() + " ");
            }
        }

    }
}
