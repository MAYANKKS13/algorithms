package com.learn.algorithms.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RightViewOfBST {
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

        System.out.println(rightView(root));
    }

    public static List<Integer> rightView(BinaryTree root) {
        Map<Integer, List<BinaryTree>> levelMap = new HashMap<>();
        rightViewHelper(root, 0, levelMap);
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < levelMap.size(); i++) {
            results.add(levelMap.get(i).get(0).data);
        }
        return results;
    }

    public static void rightViewHelper(BinaryTree root, int level, Map<Integer, List<BinaryTree>> levelMap) {
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
        rightViewHelper(root.right, level + 1, levelMap);
        rightViewHelper(root.left, level + 1, levelMap);

    }
}
