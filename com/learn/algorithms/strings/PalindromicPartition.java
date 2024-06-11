package com.learn.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {
    public static void main(String[] args) {
        String s = "aaba";
        String s1 = "a";
        System.out.println(partition(s));
        System.out.println(partition(s1));

    }

    public static List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, result, new ArrayList<>());
        return result;

    }

    public static void partitionHelper(String s, int index, List<List<String>> result, List<String> temp){
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(checkPalindrome(s.substring(index, i + 1))){
                temp.add(s.substring(index, i + 1));
                partitionHelper(s, i + 1, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean checkPalindrome(String s){
        int end = s.length() - 1;
        int start = 0;
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
