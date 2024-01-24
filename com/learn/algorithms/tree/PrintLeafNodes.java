package com.learn.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeafNodes {
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

        printLeafNodes(root);
        System.out.println();
        printLeafNodes1(root);

    }

    public static void printLeafNodes(BinaryTree root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            System.out.print(root.data + " ");
        printLeafNodes1(root.left);
        printLeafNodes1(root.right);

    }

    public static void printLeafNodes1(BinaryTree root) {
        Queue<BinaryTree> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            BinaryTree temp = bfsQueue.poll();
            if (temp.left != null)
                bfsQueue.add(temp.left);
            if (temp.right != null)
                bfsQueue.add(temp.right);
            if (temp.right == null && temp.left == null) {
                System.out.print(temp.data + " ");
            }
        }
    }
}
