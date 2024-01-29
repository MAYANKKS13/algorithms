package com.learn.algorithms.disjointset;

public class DisJointSet {

    public static void main(String[] args) {
        int[][] nodes = {
                {1, 3},
                {0, 1},
                {0, 2},
                {4, 5},
                {1, 4},
                {2, 5}
        };
        DisJointSet ds = new DisJointSet(6);

        for(int[] i : nodes){
            System.out.println(ds.union(i[0], i[1]));
        }
    }

    int[] parent;

    public DisJointSet(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int n) {
        if (n == parent[n]) {
            return n;
        }
        return find(parent[n]);
    }

    public boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        } else {
            parent[a] = b;
        }
        return true;
    }
}
