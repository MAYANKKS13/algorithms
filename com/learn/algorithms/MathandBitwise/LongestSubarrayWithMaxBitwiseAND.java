package com.learn.algorithms.MathandBitwise;

public class LongestSubarrayWithMaxBitwiseAND {
    public static void main(String[] args) {
        int nums[] = {1, 3, 3, 2, 4, 4};
        System.out.println(longestSubarray(nums));

    }

    public static int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int maxLength = 0, temp = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == max) {
                temp = temp + 1;
                maxLength = Math.max(temp, maxLength);
            }
            else {
                temp = 0;
            }
        }
        return maxLength;
    }
}
