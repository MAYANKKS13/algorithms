package com.learn.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDownToUp {
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

        bfsDownToUp(root);
    }

    public static void bfsDownToUp(BinaryTree root) {
        Queue<BinaryTree> bfsQueue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            BinaryTree temp = bfsQueue.poll();
            stack.push(temp.data);
//            System.out.print(temp.data + " ");
            if (temp.right != null)
                bfsQueue.add(temp.right);
            if (temp.left != null)
                bfsQueue.add(temp.left);

        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
