package com.learn.algorithms.graph;

public class IslandsProblem {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };

        System.out.println(noOfIslands(matrix));

    }

    public static int noOfIslands(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean visited[][] = new boolean[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    count++;
                    noOfIslandsHelper(matrix, visited, i, j);
                }
            }
        }
        return count;
    }


    public static void noOfIslandsHelper(int[][] matrix, boolean visited[][], int m, int n) {

        if (visited[m][n] == true) {
            return;
        }
        int r = matrix.length;
        int c = matrix[0].length;

        visited[m][n] = true;
        if (isValid(r, c, m - 1, n) && matrix[m - 1][n] == 1) {
            noOfIslandsHelper(matrix, visited, m - 1, n);
        }
        if (isValid(r, c, m, n + 1) && matrix[m][n + 1] == 1) {
            noOfIslandsHelper(matrix, visited, m, n + 1);
        }
        if (isValid(r, c, m + 1, n) && matrix[m + 1][n] == 1) {
            noOfIslandsHelper(matrix, visited, m + 1, n);
        }
        if (isValid(r, c, m, n - 1) && matrix[m][n - 1] == 1) {
            noOfIslandsHelper(matrix, visited, m, n - 1);
        }
        if (isValid(r, c, m - 1, n - 1) && matrix[m - 1][n - 1] == 1) {
            noOfIslandsHelper(matrix, visited, m - 1, n - 1);
        }
        if (isValid(r, c, m - 1, n + 1) && matrix[m - 1][n + 1] == 1) {
            noOfIslandsHelper(matrix, visited, m - 1, n + 1);
        }
        if (isValid(r, c, m + 1, n + 1) && matrix[m + 1][n + 1] == 1) {
            noOfIslandsHelper(matrix, visited, m + 1, n + 1);
        }
        if (isValid(r, c, m + 1, n - 1) && matrix[m + 1][n - 1] == 1) {
            noOfIslandsHelper(matrix, visited, m + 1, n - 1);
        }
    }

    public static boolean isValid(int r, int c, int m, int n) {
        return m >= 0 && m < r && n >= 0 && n < c;
    }

}
