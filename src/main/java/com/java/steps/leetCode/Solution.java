package com.java.steps.leetCode;

import java.util.*;

/**
 * @Author ：Stupid Boy
 * @Date ：2019/4/7 16:23
 * @Version ：1.0
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("aaa");
        wordDict.add("aaaa");
        // System.out.println(wordBreak(s, wordDict));
        int[] nums = { 1, 2 };
        nums = plusOne(nums);
        for (int var : nums) {
            System.out.println(var);
        }
    }

    /**
     * 加1
     * 
     * @param digits：数组代表一个正整数,每位一个数字
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int[] result;
        int mark = 1;
        for (int a : digits) {
            if (a != 9)
                mark = 0;
        }
        if (mark == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        } else {
            result = new int[digits.length];
            int flag = 1;
            int j = result.length - 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (flag == 1 && digits[i] == 9) {
                    result[j--] = 0;
                } else {
                    if (i == digits.length - 1)
                        result[j--] = digits[i] + 1;
                    else
                        result[j--] = digits[i] + flag;
                    flag = 0;
                }
            }
        }
        return result;
    }

    /**
     * 寻找最大数，是其他数的2倍以上
     * 
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[index])
                index = i;
        }
        for (int a : nums) {
            if (a != nums[index] && a != 0) {
                if (nums[index] / a < 2)
                    return -1;
            }
        }
        return index;
    }

    /**
     * 寻找中心索引
     * 
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        if (nums.length == 0 || nums.length == 2)
            return -1;
        if (nums.length == 1)
            return 0;
        int index = 0;
        while (index < nums.length) {
            int countLeft = 0, countRight = 0;
            for (int i = 0; i < index; i++) {
                countLeft += nums[i];
            }
            for (int j = index + 1; j < nums.length; j++) {
                countRight += nums[j];
            }
            if (countLeft == countRight)
                break;
            index++;
        }
        if (index > nums.length - 1)
            return -1;
        return index;
    }

    /**
     * 
     * @param s        字典匹配
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int begin = 0;
        int end = 1;
        StringBuilder builder = new StringBuilder();
        while (end <= s.length()) {
            if (wordDict.contains(s.substring(begin, end))) {
                if (end + 1 <= s.length() && wordDict.contains(s.substring(begin, end + 1))) {
                    end++;
                } else {
                    builder.append(s.substring(begin, end));
                    begin = end;
                    end = begin + 1;
                }
            } else {
                end++;
            }
        }
        if (builder.toString().equals(s))
            return true;
        return false;
    }

    /**
     * 分割回文串
     * 
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> outList = new ArrayList<List<String>>();
        List<String> inList = new ArrayList<String>();
        if (s.length() == 0)
            return outList;
        int start = 0, end = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {

            }
        }
        while (end <= s.length()) {
            String subStr = s.substring(start, end);
            if (isPalindrome(subStr)) {
                inList.add(subStr);
                start = s.indexOf(subStr) + subStr.length();
                end = start + 1;
            } else {
                end++;
            }

        }
        outList.add(inList);
        return outList;
    }

    /**
     * 验证回文串
     * 
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.length() == 0 || s.length() == 1)
            return true;
        ArrayList<Character> list = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122))
                list.add(c);
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * 找出数组中不重复的那个数（异或，hashset）
     * 
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(nums[i])) {
                Collection<Integer> values = map.values();
                values.remove(nums[i]);
            } else {
                map.put(i, nums[i]);
            }
        }
        for (Integer a : map.values()) {
            target = a;
        }
        return target;
    }

    /**
     * 找出众数
     * 
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int a : nums)
            set.add(a);
        for (int b : set.toArray(new Integer[set.size()])) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (b == nums[j]) {
                    count++;
                }
            }
            if (count <= size / 2) {
                set.remove(b);
            }
        }

        return set.toArray(new Integer[set.size()])[0];
    }

    /**
     * 搜索二维矩阵，横竖递增
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int size = matrix.length;
        if (size == 0)
            return false;
        int length = matrix[0].length;
        int i = 0;
        int j = length - 1;
        while (i < size && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }

    /**
     * 外排
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, t = 0, p = 0;
        int[] tmp = new int[m];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                tmp[t++] = nums1[i++];
            } else {
                tmp[t++] = nums2[j++];
            }
        }
        while (i < m)
            tmp[t++] = nums1[i++];
        while (j < n)
            tmp[t++] = nums2[j++];
        for (int a : tmp) {
            nums1[p++] = a;
        }
    }

    /**
     * 鸡蛋下落问题
     * 
     * @param K：鸡蛋数量
     * @param N：楼层高度
     * @return 最少次数
     */
    public static int superEggDrop(int K, int N) {
        return 0;
    }

}
