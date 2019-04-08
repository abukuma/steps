package com.java.steps.leetCode;

import java.util.*;

/**
 * @Author ：Stupid Boy
 * @Date ：2019/4/7 16:23
 * @Version ：1.0
 * @Description:
 */
public class Solution {
    /**
     * 找出数组中不重复的那个数（异或，hashset）
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int target = 0;
        for(int i = 0;i<nums.length;i++){
            if(map.containsValue(nums[i])){
                Collection<Integer> values = map.values();
                values.remove(nums[i]);
            }else{
                map.put(i,nums[i]);
            }
        }
        for (Integer a:map.values()
             ) {
            target = a;
        }
        return target;
    }

    /**
     * 找出众数
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for(int a:nums) set.add(a);
        for(int b:set.toArray(new Integer[set.size()]))
        {
            int count = 0;
            for(int j = 0;j<size;j++){
                if(b==nums[j]){
                    count++;
                }
            }
            if(count<=size/2){
                set.remove(b);
            }
        }

        return set.toArray(new Integer[set.size()])[0];
    }

    /**
     * 搜索二维矩阵，横竖递增
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int size = matrix.length;
        if(size==0) return false;
        int length = matrix[0].length;
        int i = 0;
        int j = length-1;
        while(i<size&&j>=0){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target){
                j--;
            }
            else if(matrix[i][j]<target){
                i++;
            }
        }
        return false;
    }

    /**
     * 外排
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j =0 , t =0 , p =0;
        int[] tmp = new int[m];
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                tmp[t++] = nums1[i++];
            }else{
                tmp[t++] = nums2[j++];
            }
        }
        while(i<m) tmp[t++] = nums1[i++];
        while(j<n) tmp[t++] = nums2[j++];
        for(int a:tmp){
            nums1[p++] = a;
        }
    }

    public static int superEggDrop(int K, int N) {
        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = {2,2,1,3,1,5,3};
//        System.out.println(singleNumber(nums));
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
}
