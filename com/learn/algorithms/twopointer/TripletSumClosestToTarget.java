package com.learn.algorithms.twopointer;
import java.util.Arrays;

/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.
Example: Input: nums = [-1,2,1,-4], target = 1, Output: 2, Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */


public class TripletSumClosestToTarget {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 1, -4};
        System.out.println(sumClosestToTarget(arr, 1));

    }

    public static int sumClosestToTarget(int[] arr, int target) {
        Arrays.sort(arr);
        int min = arr[0] + arr[1] + arr[arr.length - 1];
        int k = arr.length;
        for (int i = 0; i < k-2; i++) {
            int m = i + 1;
            int n = arr.length - 1;
            while (m < n) {
                int t = arr[i] + arr[m] + arr[n];
                if (Math.abs(target - t) < Math.abs(target - min)) {
                    min = t;
                } else if (t > target) {
                    n--;
                } else if (t < target) {
                    m++;
                }
                else {
                    return t;
                }
            }
        }
        return min;
    }
}
