package com.learn.algorithms.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RangeSumofSortedSubarraySums {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = 4, left = 1, right = 10;
        System.out.println(rangeSum(nums, n, left, right));


    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        long m = (n * (n + 1))/2;

        PriorityQueue<Long> heap = new PriorityQueue<>();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long tempSum = 0;
            for (int j = i; j < n; j++) {
                tempSum += nums[j];
                heap.add(tempSum);
            }
        }
        for (int k = 1; k < left; k++) {
            heap.poll();
        }
        for (int a = left; a <= right; a++) {
            sum = (sum + heap.poll()) % 1000000007;
        }
        return (int)sum;
    }
}
