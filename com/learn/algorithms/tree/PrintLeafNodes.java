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
    }

    public static void printLeafNodes(BinaryTree root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            System.out.print(root.data + " ");
        printLeafNodes(root.left);
        printLeafNodes(root.right);

    }
}
