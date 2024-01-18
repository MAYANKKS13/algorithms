package com.learn.algorithms.slidingwindow.variablesize;

public class LongestSubarrayOfSumK {
    public static void main(String[] args) {

        int[] arr = new int[]{2, -1, 1, -2, 2};
        int k = 1;
        System.out.println(longestSubarraySumBruteForce(arr, k));

    }


    public static int longestSubarraySum(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0, sum = 0;
        int n = arr.length;
        while (j < n) {
            sum += arr[j];
            if (sum < k)
                j++;
            else if (sum == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (sum > k) {
                sum = sum - arr[i];
                i++;
                j++;
            }
        }

        return max;
    }


    public static int longestSubarraySumBruteForce(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == k)
                    max = Math.max(max, j - i + 1);
            }
            sum = 0;
        }
        return max;
    }
}
