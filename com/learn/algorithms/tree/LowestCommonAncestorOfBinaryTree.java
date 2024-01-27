package com.learn.algorithms.tree;

public class LowestCommonAncestorOfBinaryTree {
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

        System.out.println(lca(root, 18, 20).data);

    }

    public static BinaryTree lca(BinaryTree root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.data == p || root.data == q) {
            return root;
        }
        BinaryTree left = lca(root.left, p, q);
        BinaryTree right = lca(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
