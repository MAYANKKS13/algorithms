package com.learn.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test6 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 4};
        System.out.println(maxFrequencyElements(nums));

    }

    public static int maxFrequencyElements(int[] nums) {
        int count = 0;
        int maxValue = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i], value+1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        for(int j : map.values()){
            maxValue = Math.max(j, maxValue);
        }
        for(int frequency : map.values()){
            if(frequency == maxValue){
                count = count + frequency;
            }
        }
        return count;
    }

//    public static boolean duplicates(int[] nums, int k){
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i])){
//                if(Math.abs(i - map.get(nums[i])) > k){
//                    map.put(nums[i], i);
//                }
//                if(Math.abs(i - map.get(nums[i])) <= k){
//                    return true;
//                }
//            }
//            else{
//                map.put(nums[i], i);
//            }
//        }
//        return false;
//    }
}
