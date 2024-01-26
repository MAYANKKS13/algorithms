package com.learn.algorithms.tree;

import java.util.*;

public class LeftViewOfBST {
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

//        leftViewOfBST(root);
        System.out.println(leftView(root));

    }

    public static List<Integer> leftView(BinaryTree root) {
        Map<Integer, List<BinaryTree>> levelMap = new HashMap<>();
        leftViewHelper(root, 0, levelMap);
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < levelMap.size(); i++) {
            results.add(levelMap.get(i).get(0).data);
        }
        return results;
    }


    public static void leftViewHelper(BinaryTree root, int level, Map<Integer, List<BinaryTree>> levelMap) {
        if (root == null) {
            return;
        }
        if (levelMap.containsKey(level)) {
            List<BinaryTree> binaryTreeList = levelMap.get(level);
            binaryTreeList.add(root);
            levelMap.put(level, binaryTreeList);
        } else {
            List<BinaryTree> binaryTreeList = new ArrayList<>();
            binaryTreeList.add(root);
            levelMap.put(level, binaryTreeList);
        }
        leftViewHelper(root.left, level + 1, levelMap); //Calling this function after the next recursive function will give the right view of the BST.
        //Explanation:- Calling root.right call first will traverse the right subtree first and hence give the first element i.e. right most element of each level first hence giving us the right view.
        leftViewHelper(root.right, level + 1, levelMap);
    }

}
