package com.learn.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMaze {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        System.out.println(shortestPathBinaryMaze(matrix,0,0,3,4));
        System.out.println(shortestPathBinaryMaze(matrix, 1, 2,3, 7));
        System.out.println(shortestPathBinaryMaze(matrix, 0, 0,8, 9));


    }

    private static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    private static int[] dy = {0, -1, 0, 1, -1, -1, 1, 1};

    public static int shortestPathBinaryMaze(int[][] matrix, int sourceX, int sourceY, int destX, int destY) {

        int r = matrix.length;
        int c = matrix[0].length;
        boolean[][] visited = new boolean[r][c];

        visited[sourceX][sourceY] = true;

        Queue<NodePath> queue = new LinkedList<>();
        queue.add(new NodePath(sourceX, sourceY, 0));

        while (!queue.isEmpty()) {
            NodePath temp = queue.poll();

            if (temp.x == destX && temp.y == destY) {
                return temp.distance;
            }

            for (int i = 0; i < dx.length; i++) {
                if (isValid(r, c, temp.x + dx[i], temp.y + dy[i]) && matrix[temp.x + dx[i]][temp.y + dy[i]] == 1 && !visited[temp.x + dx[i]][temp.y + dy[i]]) {
                    visited[temp.x + dx[i]][temp.y + dy[i]] = true;
                    queue.add(new NodePath(temp.x + dx[i], temp.y + dy[i], temp.distance + 1));
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int r, int c, int m, int n) {
        return m >= 0 && m < r && n >= 0 && n < c;
    }
}

class NodePath {
    int x;
    int y;
    int distance;

    public NodePath(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
