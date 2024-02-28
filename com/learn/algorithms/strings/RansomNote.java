package com.learn.algorithms.strings;

import java.util.Arrays;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
        int m = Integer.MIN_VALUE;

    }

    public static boolean canConstruct(String ransomNote, String magazine){
        String new2 = mySort(ransomNote);
        String new1 = mySort(magazine);
        int j = 0;
        for(int i = 0; i < magazine.length(); i++){
            if(j < new2.length() && new2.charAt(j) == new1.charAt(i)){
                j++;
            }
        }
        if(j == ransomNote.length()){
            return true;
        }
        return false;
    }

    public static String mySort(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
