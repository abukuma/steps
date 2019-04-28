package com.java.steps.leetCode;

import java.util.HashSet;
import java.util.Set;

public class ArraySolution {
    public static void main(String[] args) {

    }

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
     * 合并两个有序数组
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
}