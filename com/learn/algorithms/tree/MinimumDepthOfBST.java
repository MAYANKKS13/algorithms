package com.learn.algorithms.tree;

public class MinimumDepthOfBST {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(8);
        root.right = new BinaryTree(15);
        root.right.left = new BinaryTree(14);
        root.left.left = new BinaryTree(6);
        root.left.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(9);
        root.right.right = new BinaryTree(20);
        root.right.right.left = new BinaryTree(18);
        root.right.right.right = new BinaryTree(25);

//        minimumDepthOfBSt(root);
        System.out.println(minimumDepth(root));
    }

    public static int minimumDepth(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int lc = root.left != null ? minimumDepth(root.left) : Integer.MAX_VALUE;
        int rc = root.right != null ? minimumDepth(root.right) : Integer.MAX_VALUE;
        return 1 + Math.min(lc, rc);
    }

}
