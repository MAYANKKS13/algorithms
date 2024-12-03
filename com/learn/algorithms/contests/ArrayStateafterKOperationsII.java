package com.learn.algorithms.contests;

import java.util.PriorityQueue;

public class ArrayStateafterKOperationsII {
    public static void main(String[] args) {
       int[] nums = {2,1,3,5,6};
       int[] nums1 = {100000,2000};
       printArray(getFinalState(nums, 5, 2));
        System.out.println();
       printArray(getFinalState(nums1, 2, 1000000));

    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        int m = 1000000007;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0]!=b[0] ? a[0] - b[0] : a[1] - b[1]);

        for(int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        while(k > 0) {
            int[] min = queue.poll();
            long current = (long) min[0] * multiplier;
            nums[min[1]] = (int) (current%m);
            queue.offer(new int[]{(int) (current%m), min[1]});
            k--;
        }
        return nums;
    }

    public static void printArray(int[] nums) {
        for (int num:nums) {
            System.out.print(num + " ");
        }
    }

}
