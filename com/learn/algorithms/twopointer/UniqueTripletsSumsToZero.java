package com.learn.algorithms.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
 */


public class UniqueTripletsSumsToZero {
    public static void main(String[] args) {

//        int[] arr = new int[]{-3,0,1,2,-1,1,-2};
        int[] arr = new int[]{-2, 1, 0, 3, -5, -3, 2};
//        int[] arr =new int[]{1,1,1,1,1};
        Arrays.sort(arr);
        System.out.println(tripletsSumsZero(arr));
    }

    public static List<List<Integer>> tripletsSumsZero(int[] arr) {
        int k = arr.length - 1;
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int m = i + 1;
            int target = -arr[i];
            for (int j = i + 1; j < k; j++) {
                if (arr[m] + arr[k] < target) {
                    m++;
                } else if (arr[m] + arr[k] > target) {
                    k--;
                } else {
                    results.add(List.of(arr[i], arr[m], arr[k]));
                    m++;
                    k--;
                }
            }
            k = arr.length - 1;
        }
        return results;
    }
}
