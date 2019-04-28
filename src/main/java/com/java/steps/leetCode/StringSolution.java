package com.java.steps.leetCode;

public class StringSolution {
    public static void main(String[] args) {
        
    }

    /**
     * 仅仅反转字母
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            while(i<arr.length&&(!((arr[i]>=65&&arr[i]<=90)||(arr[i]>=97&&arr[i]<=122))))
                i++;
            while(j>=0&&(!((arr[j]>=65&&arr[j]<=90)||(arr[j]>=97&&arr[j]<=122))))
                j--;
            if(i<j){
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        String result = new String(arr);
        return result;
    }

        /**
     * 原语分解+外层括号去除
     * @param S
     * @return
     */
    public static String removeOuterParentheses(String S) {
        StringBuilder builder = new StringBuilder();
        char[] arr = S.toCharArray();
        int count=0;
        int beginIndex=0;
        for(int i=0;i<arr.length;i++){
           if(arr[i]=='(') count++;
           else count--;
           if(count==0&&0!=i){
               String str = S.substring(beginIndex, i+1);
               beginIndex = i+1;
               builder.append(str.substring(1, str.length()-1));
           }
        }
        return builder.toString();   
       }
}