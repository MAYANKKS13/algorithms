package com.learn.algorithms.heap;

import java.util.PriorityQueue;

/*
Connect Ropes
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost. The cost of connecting two ropes is equal to the sum of their lengths.
Input: [1, 3, 11, 5]
Output: 33
Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
Input: [3, 4, 5, 6]
Output: 36
Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
Input: [1, 3, 11, 5, 2]
Output: 42
Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)
 */

public class ConnectRopes {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 11, 5};
        int[] arr1 = new int[]{3, 4, 5, 6};
        int[] arr2 = new int[]{1, 3, 11, 5, 2};
        System.out.println(cost(arr));
        System.out.println(cost(arr1));
        System.out.println(cost(arr2));
    }

    public static int cost(int[] arr) {
        PriorityQueue<Integer> costQueue = new PriorityQueue<>();
        for (int i : arr) {
            costQueue.add(i);
        }
        int min_cost = 0;
        while (!costQueue.isEmpty()) {
            if (costQueue.size() == 1)
                break;
            int x = costQueue.poll();
            int y = costQueue.poll();
            min_cost = min_cost + x + y;
            costQueue.add(x + y);
        }
        return min_cost;
    }
}
