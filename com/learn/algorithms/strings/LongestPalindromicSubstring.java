package com.learn.algorithms.strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "abbd";
        String s1 = "racecar";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s1));
        System.out.println(checkPalindrome(s, 0, s.length()));
        System.out.println(checkPalindrome(s1, 0, s1.length()));

    }

    public static String longestPalindrome(String s) {
        String result = "";


        return  result;
    }

    public static boolean checkPalindrome(String s, int start, int end) {
        int i = start, j = end-1;
        for(int k = start; k < s.length()/2; k++) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
