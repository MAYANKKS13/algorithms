package com.learn.algorithms.tree;

public class DiameterOfBinaryTree {
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

        System.out.println(diameter(root));

    }

    public static int diameter(BinaryTree root) {
        int lc = 0;
        int rc = 0;
        if (root == null)
            return 0;
        if (root.left != null) {
            lc = diameter(root.left);
        }
        if (root.right != null) {
            rc = diameter(root.right);
        }

        int dia = lc + rc + 1;
        return Math.max(dia, Math.max(lc, rc));
    }
}
