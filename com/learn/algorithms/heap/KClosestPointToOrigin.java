package com.learn.algorithms.heap;

/*
'K' Closest Points to the Origin (easy)
Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.
Input: points = [[1,2],[1,3]], K = 1
Output: [[1,2]]
Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
The Euclidean distance between (1, 3) and the origin is sqrt(10).
Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
Input: point = [[1, 3], [3, 4], [2, -1]], K = 2
Output: [[1, 3], [2, -1]]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {3, 4}, {2, -1}};
        System.out.println(kClosestPoint(arr, 2));

    }

    public static List<Point> kClosestPoint(int[][] arr, int k) {

        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> (b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y));
        List<Point> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            maxHeap.add(new Point(arr[i][0], arr[i][1]));
        }
        for (int i = k; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            Point point = maxHeap.peek();
            if ((x * x + y * y) < (point.x * point.x + point.y * point.y)) {
                maxHeap.poll();
                maxHeap.add(new Point(x, y));
            }

        }
        results = maxHeap.stream().toList();
        return results;
    }


}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ']';
    }
}
