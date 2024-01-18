package com.learn.algorithms.twopointer;

import java.util.*;

/*
  Given a sorted array of numbers and a target sum. Find the pairs which equals to this target sum.
  Ex:- 1) arr={1,2,3,4,6},  target=6
          Output:- [2,4]

       2) arr={-10,10,20,30,60},  target=50
          Output:- [-10,60], [20,30]

 */

public class PairEqualsTargetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-10, 10, 20, 30, 60};
        int targetSum = 50;

        System.out.println(FindPairUsingSet(arr, targetSum));
        System.out.println(FindPairUsingTwoPointer(arr, targetSum));

    }


    public static List<List<Integer>> FindPairUsingTwoPointer(int[] arr, int target) {
        int j = arr.length - 1;
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < j; i++) {
            if (arr[i] + arr[j] > target) {
                j--;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else {
                results.add(List.of(arr[i],arr[j]));
            }
        }
        if(results.isEmpty()) {
            results.add(List.of(-1,-1));
        }
        return results;
    }

    public static List<List<Integer>> FindPairUsingSet(int[] arr, int target) {
        Set<Integer> set = new HashSet<Integer>();
        List<List<Integer>> results =  new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(target - arr[i])) {
                set.add(arr[i]);
            } else if (set.contains(target - arr[i])) {
                // return new int[]{target - arr[i], arr[i]};
                results.add(List.of(target - arr[i], arr[i]));
            }
        }
        if(results.isEmpty()) {
            results.add(List.of(-1,-1));
        }
        return results;
    }

}
