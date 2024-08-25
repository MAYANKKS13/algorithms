package com.learn.algorithms.contests;

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
        for(int i = 0; i < k; i++) {
            int index = 0;
            for(int j=1; j < nums.length; j++) {
                if(nums[index] > nums[j]) {
                    index = j;
                }
            }
            long current = (long) nums[index] * multiplier;
            nums[index] = (int) (current%m);
        }
        return nums;
    }

    public static void printArray(int[] nums) {
        for (int num:nums) {
            System.out.print(num + " ");
        }
    }

}
