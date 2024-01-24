package com.learn.algorithms.heap;

/*
'K' Closest Numbers (medium)
Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
Input: [5, 6, 7, 8, 9], K = 3, X = 7
Output: [6, 7, 8]
Input: [2, 4, 5, 6, 9], K = 3, X = 6
Output: [4, 5, 6]
Input: [2, 4, 5, 6, 9], K = 3, X = 10
Output: [5, 6, 9]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestNumberToX {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 9};
        int[] arr1 = new int[]{2, 4, 5, 6, 9};
        int[] arr2 = new int[]{2, 4, 5, 6, 9};
        System.out.println(kClosestNumberToX(arr, 3, 7));
        System.out.println(kClosestNumberToX(arr1, 3, 6));
        System.out.println(kClosestNumberToX(arr2, 3, 10));


    }

    public static List<Integer> kClosestNumberToX(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            maxHeap.add(Math.abs(arr[i] - x));
        }
        for (int i = k; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(Math.abs(arr[i] - x));
            }
        }

        for (int i = 0; i < k; i++) {
            if (result.contains(x - maxHeap.peek())) {
                result.add(maxHeap.poll() + x);
                break;
            }
            result.add(x - maxHeap.poll());

        }

        return result;
    }
}

