package com.java.steps.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.java.steps.leetCode.entity.TreeNode;

public class BinaryTreeSolution {
    public static void main(String[] args) {
        
    }

    /**
     * 中序遍历
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return recursive_mid(list, root);
    }

    public static List<Integer> recursive_mid(List<Integer> list,TreeNode node){
        while(node!=null){
            // if(){}
            if(node.left!=null) return recursive_mid(list, node.left);
            list.add(node.val);
            if(node.right!=null) return recursive_mid(list, node.right);
        }
        return list;
    }

    /**
     * 先序遍历--迭代实现
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode left = null ,right = null,head = null;
        
        if(root!=null) {
            list.add(root.val);
            head = root;
            left = root.left;
            right = root.right;
        }
        while(left!=null||right!=null){
            if(left!=null){
                head = root.left;
                list.add(head.val);
            }
        }
        return list;
    }
    /**
     * 先序遍历--递归实现
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        list = recursive_pre(list,root);
        return list;
    }

    public static List<Integer> recursive_pre(List<Integer> list,TreeNode node){
        if(node==null) return list;
        if(node.left==null&&node.right==null){
            list.add(node.val);
        }
        if(node.left!=null||node.right!=null) {
            list.add(node.val);
            recursive_pre(list,node.left);
            recursive_pre(list,node.right);
        }

        return list;
    }
}