package com.learn.algorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Test5 {
    public static void main(String[] args) {

        /** Relative sort array

         int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
         int[] arr2 = new int[]{2,1,4,3,9,6};
         int[] result = relativeSortArray(arr1, arr2);
         for(int p = 0; p < result.length; p++){
         System.out.print(result[p] + " ");
         }
         */

        int[] nums = new int[]{1, 2, 3, 4};
//        Output: [24,12,8,6]

        int[] nums1 = new int[]{-1, 1, 0, -3, 3};
//        Output: [0,0,9,0,0]

        System.out.println(productExceptSelf(nums));


    }


    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];
        int multiply = 1;
        int countZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countZero++;
                continue;
            }
            multiply = multiply * nums[i];
        }
        if (countZero == 0) {
            for (int j = 0; j < n; j++) {
                results[j] = multiply / nums[j];
            }
        }
        if (countZero == 1) {
            for (int j = 0; j < n; j++) {
                if(nums[j] == 0){
                    results[j] = multiply;
                }
                results[j] = 0;
            }
        }
        if (countZero > 1) {
            for(int m = 0; m < n; m++){
                results[m] = 0;
            }
        }
        return results;
    }















    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                int value = map.get(arr1[i]);
                map.put(arr1[i], value + 1);
            }
            map.put(arr1[i], 1);
        }
        int index = 0;
        for (int j = 0; j < arr2.length; j++) {
            for (int m = 0; m < map.get(arr2[j]); m++) {
                arr1[index] = arr2[j];
                index++;
            }
            map.remove(arr2[j]);
        }
        for (Integer k : map.keySet()) {
            for (int n = 0; n < map.get(k); n++) {
                arr1[index] = k;
                index++;
            }
        }
        return arr1;
    }

}



