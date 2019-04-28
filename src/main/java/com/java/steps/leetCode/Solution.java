package com.java.steps.leetCode;
import com.java.steps.javase.WeekEnum;
import java.util.*;
import java.util.Map.Entry;




/**
 * @Author ：Stupid Boy
 * @Date ：2019/4/7 16:23
 * @Version ：1.0
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        /**TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left =node2;
        List<Integer> list = inorderTraversal(root);
        System.out.println(list.toString());*/
        // Stack<Integer> stack = new Stack<Integer>();
        // Queue<String> queue = new LinkedBlockingQueue<String>();
        
        for(WeekEnum weekEnum:WeekEnum.values())
        System.out.println(weekEnum.name());
    }

    /**
     * 除数博弈
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        List<Integer> result = new ArrayList<Integer>();
        result = next(N, result, 1);
        // for(int a: result){
        //     if(a%2==1) 
        // }
        return true;
    }

    public static List<Integer> next(int N,List<Integer> arr,int count){
        if(N==1) {
            arr.add(count++);
            return arr;
        }
        int[] result = findNum(N);
        for(int a:result){
            while(a!=0){
                next(N-a,arr,count++);
            }

        }
        return null;
    }

    /**
     * 找出因数
     * @param N
     * @return
     */
    public static int[] findNum(int N){
        int[] result = new int[N];
        for(int i=1,j=0;i<N;i++){
            if(N%i==0) result[j++]=i;
        }
        return result;
    }

    /**
     * 马落在棋盘的概率
     * @param N N*N的棋盘
     * @param K 移动步数
     * @param r 初始横坐标
     * @param c 初始纵坐标
     * @return
     */
    public double knightProbability(int N, int K, int r, int c) {
        double probability = 0;

        return probability;
    }

    // public static double move(int N, int K, int r, int c){
    //     if(K==1) return calculate(N, r, c);
    // }

    public static double calculate(int N,int r, int c){
        double successRoute = 0;
        if(r-2>=0 && c-1>=0) {
            successRoute++;
        }
        if(r-2>=0 && c+1<N) {
            successRoute++;
        }
        if(r+2<N && c-1>=0) {
            successRoute++;
        }
        if(r+2<N && c+1<N) {
            successRoute++;
        }
        if(r-1>=0 && c-2>=0) {
            successRoute++;
        }
        if(r-1>=0 && c+2<N) {
            successRoute++;
        }
        if(r+1<N && c-2>=0) {
            successRoute++;
        }
        if(r+1<N && c+2<N) {
            successRoute++;
        }         
        double result = successRoute/8;
        return result;
    }

    

    /**
     * 构造矩形，长宽差值最小
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =1;i<=Math.sqrt(area);i++){
            if(area%i==0) map.put(area/i,i);
        }
        int minKey=0;
        int distance=area;
        for(Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey()-entry.getValue()<distance){
                distance = entry.getKey()-entry.getValue();
                minKey = entry.getKey();
            }
        }
        result[0]=minKey;
        result[1]=map.get(minKey);
        return result;
    }

    /**
     * 输出前K出现频率的元素
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int a:nums){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }
        List<Entry<Integer,Integer>> sortList = new LinkedList<Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(sortList, new Comparator<Entry<Integer,Integer>>() {
            @Override
            public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int size = sortList.size();
        for(int i = size-1;i>=size-k;i--){
            list.add(sortList.get(i).getKey());
        }
        return list;
    }

    /**
     * 根据字符出现频率排序
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        StringBuilder builder = new StringBuilder();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
        List<Entry<Character,Integer>> list = new LinkedList<Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<Character,Integer>>() {
            public int compare(Entry<Character,Integer> o1, Entry<Character,Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        for (Entry<Character,Integer> entry : list) {
            for(int i=0;i<entry.getValue();i++){
                builder.append(entry.getKey());
            }
        }
        
        return builder.reverse().toString();
    }

    /**
     * 
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;

    }


    /**
     * 对角线遍历二维数组
     * 
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int M = matrix.length;
        if (M == 0)
            return null;
        int N = matrix[0].length;
        int i = 0, j = 0;
        int[] result = new int[M * N];

        for (int count = 0; count < M + N; count++) {
            while (i < M && j < N) {

            }
        }
        return result;
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
