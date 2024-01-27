package com.learn.algorithms.tree;

import java.util.*;

public class BstTraversalIterative {
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
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inOrder(root);
    }

    public static void preOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTree node = stack.pop();
            System.out.print(node.data + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void postOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        Stack<BinaryTree> stack1 = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTree temp = stack.pop();
            stack1.push(temp);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop().data + "  ");
        }
    }

    public static void inOrder(BinaryTree root) {
        if (root == null){
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree node = root;
        while(node != null || stack.size() > 0) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node=stack.peek();
            System.out.print(stack.pop().data + "  ");
            node = node.right;
        }
    }

}
