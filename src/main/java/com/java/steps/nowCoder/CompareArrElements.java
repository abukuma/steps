package com.java.steps.nowCoder;

/**
 * @Author: Stupid Boy
 * @Date: 2019/3/18 12:25
 * @Version： 1.0
 * @Description: 比较有序数组A和无序数组B，打印所有B不在A中的元素，数组A长度为N，数组B长度为M
 */
public class CompareArrElements {
    /**
     * method1:遍历数组B。O(M*N)
     */
    void traverseArr(int[] arrA , int[] arrB){
        int flag =1;
        for(int i = 0; i < arrB.length; i++){
            for(int j = 0; j < arrA.length; j++ ){
                if(arrB[i] == arrA[j]){
                    flag = 0;
                }
            }
            if(flag == 1){
                System.out.println(arrB[i]);
            }
            flag =1;
        }
    }
    /**
     * method2:数组B在数组A中进行二分查找.O(M*logN)
     */
    void method2(int[] arrA , int[] arrB){
        for(int i = 0; i < arrB.length; i++){
            boolean result = binarySearch(arrA,0,arrA.length-1,arrB[i]);
            if (!result) System.out.println(arrB[i]);
        }
    }

    static boolean binarySearch(int[] arrA ,int left ,int right ,int number){
        int mid = left + (right-left)>>1;
        if(left>right)
            return false;
        if(arrA[mid]<number) return binarySearch(arrA,mid+1, right,number);
        if(arrA[mid]>number) return binarySearch(arrA,left,mid-1,number);
        return true;
    }
}
