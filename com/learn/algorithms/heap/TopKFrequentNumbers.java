package com.learn.algorithms.heap;

/*
Top 'K' Frequent Numbers (medium)
Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
Input: [1, 3, 5, 12, 11, 12, 11], K = 2
Output: [12, 11]
Explanation: Both '11' and '12' appeared twice.
Input: [5, 12, 11, 3, 11], K = 2
Output: [11, 5] or [11, 12] or [11, 3]
Explanation: Only '11' appeared twice, all other numbers appeared once.
 */

import java.util.*;

public class TopKFrequentNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 12, 11, 12, 11};
        System.out.println(kFrequentNumbers(arr, 2));
        int[] arr1 = new int[]{1, 3, 11, 5, 3, 11, 9, 3, 12};
        System.out.println(kFrequentNumbers(arr1, 2));
        int[] arr2 = new int[]{1, 2, 7, 4, 6, 8, 3};
        System.out.println(kFrequentNumbers(arr2, 2));
    }

    public static List<Integer> kFrequentNumbers(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : arr) {

//            if(frequencyMap.containsKey(i)) {
//                int count = frequencyMap.get(i) + 1;
//                frequencyMap.put(i, count);
//            } else {
//                frequencyMap.put(i, 1);
//            }

            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        while (k > 0) {
            result.add(maxHeap.poll().x);
            k--;
        }
        return result;
    }
}

class Pair {
    int x;
    int count;

    public Pair(int x, int count) {
        this.x = x;
        this.count = count;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + count + "]";
    }
}
