package com.learn.algorithms.slidingwindow.fixedsize;

public class MaxSumOfSubArrayOfSizeK {
    public static void main(String[] args) {

        int[] arr = new int[]{0,-1,25,7,-35,45,-2,7,-120};
        int k =3;
        System.out.println(maxSumSubarray(arr, k));
    }

    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0, max = Integer.MIN_VALUE;
        while(j < n) {
            if(j - i + 1 < k) { // to reach windows size
                sum = sum + arr[j];
                j++;
            } else if(j - i + 1 == k) { // when window size is reached, then maintain the window size and iterate
                sum = sum + arr[j];
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
