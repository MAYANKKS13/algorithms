package com.learn.algorithms.tree;

import java.util.*;

public class MinimumDepthOfBST {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(8);
        root.right = new BinaryTree(15);
        root.left.left = new BinaryTree(6);
        root.left.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(9);
        root.right.right = new BinaryTree(20);
        root.right.right.left = new BinaryTree(18);
        root.right.right.right = new BinaryTree(25);

        minimumDepthOfBSt(root);
    }

    public static void minimumDepthOfBSt(BinaryTree root) {
        Queue<BinaryTree> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            BinaryTree temp = bfsQueue.poll();
            if (temp.left != null)
                bfsQueue.add(temp.left);
            if (temp.right != null)
                bfsQueue.add(temp.right);
            if (temp.left == null && temp.right == null) {
                System.out.println(temp.data);
                break;
            }
        }
    }
}
