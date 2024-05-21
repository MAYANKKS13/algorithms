package com.learn.algorithms.MathandBitwise;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums1 = {1, 4, 4, 2, 4};
        System.out.println(subsets(nums));
        System.out.println(subsets(nums1));


    }

    public static List<List<Integer>> subsets (int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();   // Set is used to avoid duplicate lists in result if the input array contains duplicate elements.
        Arrays.sort(nums);    // Important:- Array should be sorted to handle duplicate elements.
        for (int i = 0; i < (int) Math.pow(2, nums.length); i++){
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++){
                if((i & (1 << j)) != 0){
                    temp.add(nums[j]);
                }
            }
            if(!set.contains(temp)){
                set.add(temp);
            }
        }
        result.addAll(set);
        return result;
    }
}
