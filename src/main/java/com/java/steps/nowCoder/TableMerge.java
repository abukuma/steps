package com.java.steps.nowCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TableMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int mergeNum = 0;
        String str = "";
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            str = scanner.nextLine();
            if (map.get(str.charAt(0) - 48) == null) {
                map.put(str.charAt(0) - 48, str.charAt(2) - 48);
            } else {
                mergeNum = map.get(str.charAt(0) - 48);
                mergeNum += (str.charAt(2) - 48);
                map.put(str.charAt(0) - 48, mergeNum);
            }
        }
        scanner.close();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
        ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
/**
 * 题目描述
 * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * <p>
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述:
 * 输出合并后的键值对（多行）
 * <p>
 * 示例1
 * 输入
 * 复制
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 复制
 * 0 3
 * 1 2
 * 3 4
 */
