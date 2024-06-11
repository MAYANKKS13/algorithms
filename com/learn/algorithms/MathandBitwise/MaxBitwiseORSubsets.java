package com.learn.algorithms.MathandBitwise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxBitwiseORSubsets {
    public static void main(String[] args) {
        int[] nums = {3, 1, 1};
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {3, 2, 1, 5};
        System.out.println(countMaxORSubsets(nums));
        System.out.println(countMaxORSubsets(nums1));
        System.out.println(countMaxORSubsets(nums2));


    }

    public static int countMaxORSubsets(int[] nums){
        int n = nums.length;
        int maxOR = 0;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        Arrays.sort(nums);
        for(int k = 0; k < n; k++){
            maxOR = maxOR | nums[k];
        }
        for(int i = 0; i < (int) Math.pow(2, n); i++){
            int getOR = 0;
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    getOR = getOR | nums[j];
                }
            }
            if(getOR == maxOR){
                count++;
            }
        }
        return count;
    }


}
