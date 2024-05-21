package com.learn.algorithms.MathandBitwise;

import java.util.*;

public class SumofAllSubsetXORTotals {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(subsetXORSum(nums));

    }

    public static int subsetXORSum(int[] nums) {
        int totalSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < (int) Math.pow(2, nums.length); i++){
            int getXOR = 0;
            for (int j = 0; j < nums.length; j++){
                if((i & (1 << j)) != 0){
                    getXOR = getXOR ^ nums[j];
                }
            }
            totalSum = totalSum + getXOR;
        }
        return totalSum;
    }
}
