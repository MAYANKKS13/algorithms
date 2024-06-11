package com.learn.algorithms;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(pattern,str));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length() != str.length){
            return false;
        }
        Map<Character, String> map = new HashMap();
        for(int i = 0; i < str.length; i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(str[i])){
                    return false;
                }
            }
            else{
                map.put(pattern.charAt(i), str[i]);
            }
        }
        return true;
    }
}
