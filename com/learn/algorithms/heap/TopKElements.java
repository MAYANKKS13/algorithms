package com.learn.algorithms.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 12, 2, 11, 13, 7};
        System.out.println(topKElements(arr, 3));
    }
    public static List<Integer> topKElements(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> result = new ArrayList<>();
        for (int i : arr) {
            maxHeap.add(i);
        }
        while (k > 0) {
            result.add(maxHeap.poll());
            k--;
        }
        return result;
    }
}
