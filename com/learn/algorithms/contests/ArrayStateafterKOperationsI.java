package com.learn.algorithms.contests;

public class ArrayStateafterKOperationsI {
    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int[] nums1 = {1, 2};
        printArray(getFinalState(nums, 5, 2));
        System.out.println();
        printArray(getFinalState(nums1, 3, 4));

    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i = 0; i < k; i++) {
            int index = 0;
            for(int j=1; j < nums.length; j++) {
                if(nums[index] > nums[j]) {
                    index = j;
                }
            }
            nums[index] = nums[index] * multiplier;
        }

        return nums;
    }

    public static void printArray(int[] nums) {
        for (int num:nums) {
            System.out.print(num + " ");
        }
    }

}
