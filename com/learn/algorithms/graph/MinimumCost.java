package com.learn.algorithms.graph;

public class MinimumCost {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1}
        };

        System.out.println(minCost(matrix));

    }


    public static int minCost(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] cost = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cost[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        int minCost = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    cost[i][j] = 0;
                } else if (i == 0 && matrix[0][j] == 1) {
                    cost[0][j] = cost[0][j - 1] + 1;
                } else if (j == 0 && matrix[i][0] == 1) {
                    cost[i][0] = cost[i - 1][0] + 1;
                } else if (matrix[i][j] == 1) {
                    cost[i][j] = 1 + Math.min(Math.min(cost[i - 1][j], cost[i][j - 1]), cost[i - 1][j - 1]);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
        return cost[r - 1][c - 1];
    }
}
