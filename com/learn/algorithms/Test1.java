package com.learn.algorithms;

import java.lang.reflect.Array;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
//        int[] nums = new int[0];
//        String haystack = "absabutsd";
        String needle = "aabccabba";
        System.out.println(minimumLength(needle));



    }

    public static int minimumLength(String s) {
        int minLength = 0;
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                minLength = (j - i + 1);
            } else if (s.charAt(i) == s.charAt(j)) {
                while (i <= j && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
                while (i <= j && s.charAt(j) == s.charAt(j - 1)) {
                    j--;
                }
            }
            i++;
            j--;
        }
        return minLength;
    }










//    public static int strStr(String haystack, String needle) {
//          int index = 0;
//          for(int i = 0; i < haystack.length(); i++){
//              index = i;
//              int j = 0;
//              while (j < needle.length() && haystack.charAt(i) == needle.charAt(j)){
//                  i++;
//                  j++;
//                  if(j == needle.length()){
//                      return index;
//                  }
//              }
//          }
//          return -1;
//    }





//    public static int longestConsecutive(int[] nums) {
//            int max = Integer.MIN_VALUE;
//            if(nums.length == 0){
//                max = 0;
//            }
//            Set<Integer> set = new HashSet<>();
//            for(int i = 0; i < nums.length; i++){
//                set.add(nums[i]);
//            }
//            for(int i = 0; i < nums.length; i++){
//                if(!set.contains(nums[i] + 1)){
//                    int count = 1;
//                    int value = nums[i];
//                    while(set.contains(value - 1)){
//                        count++;
//                        value = value - 1;
//                    }
//                    if(count > max){
//                        max = count;
//                    }
//                }
//            }
//            return max;
//    }
}
