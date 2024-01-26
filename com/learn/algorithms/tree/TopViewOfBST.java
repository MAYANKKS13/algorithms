package com.learn.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopViewOfBST {
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



    }


    public static void topViewHelper(BinaryTree root, int level, int dist, Map<Integer, Integer> levelDist) {
        if (root == null)
            return;

        if (levelDist.containsKey(dist)) {

        } else {
            List<BinaryTree> result = new ArrayList<>();
            result.add(root);
            levelDist.put(level, dist);
        }

        topViewHelper(root.left, level + 1, dist + 1, levelDist);

    }
}
