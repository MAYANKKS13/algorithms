package com.learn.algorithms.tree;

import java.util.*;

public class ZigZagTraversal {
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

        System.out.println(zigZagTraversal(root));
    }

    public static List<List<Integer>> zigZagTraversal(BinaryTree root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        int j = -1;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            j = j + 1;
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree temp = queue.poll();
                list.add(temp.data);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if (j % 2 != 0) {
                Collections.reverse(list);
                result.add(list);
            } else if (j % 2 == 0) {
                result.add(list);
            }
        }
        return result;
    }
}
