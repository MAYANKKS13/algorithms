package com.learn.algorithms.graph;

public class ShortestPathInBinaryMaze {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        System.out.println(shortestPathBinaryMaze(matrix, 0, 0, 3, 4));

    }

    public static int shortestPathBinaryMaze(int[][] matrix, int sourceX, int sourceY, int destX, int destY) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] cost = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cost[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = sourceX; i <= destX; i++) {
            for (int j = sourceY; j <= destY; j++) {
                if (i == sourceX && j == sourceY) {
                    cost[i][j] = 0;
                } else if (i == sourceX && matrix[sourceX][j] == 1) {
                    cost[sourceX][j] = cost[sourceX][j - 1] + 1;
                } else if (j == sourceY && matrix[i][sourceY] == 1) {
                    cost[i][sourceY] = cost[i - 1][sourceY] + 1;
                } else if (matrix[i][j] == 1) {
                    cost[i][j] = 1 + Math.min(cost[i - 1][j], cost[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
        return cost[destX][destY];
    }
}
