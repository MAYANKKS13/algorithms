package com.learn.algorithms;

import java.util.*;

import static java.util.Collections.list;

public class Test4 {
    public static void main(String[] args) {

        String s = "a";
        String t = "a";
        System.out.println(isIsomorphic(s,t));

    }


    public static boolean isIsomorphic(String s, String t) {
         Map<Character, Character> map = new HashMap<>();
         int j = 0;
         if(s.length() ==1 && t.length()==1 && s.charAt(j)==t.charAt(j)){
             return true;
         }
         for(int i = 0; i < s.length(); i++){
             if(s.charAt(i)==t.charAt(i)){
                 return false;
             }
             if(map.containsKey(s.charAt(i))){
                 if(!(map.get(s.charAt(i)).equals(t.charAt(i)))){
                     return false;
                 }
             }
             map.put(s.charAt(i), t.charAt(i));
         }
         return true;
    }












//      public static int countPairs(int[] arr, int k){
//        int c = 0;
//        for(int i = 0; i<arr.length - 1;i++){
//            for (int j = i+1;j<arr.length;j++){
//                if((arr[i] == arr[j]) && (i*j)%k == 0){
//                        c++;
//                }
//            }
//        }
//        return c;
//      }

//    public static int countPairsMap(int[] arr, int k){
//        int c = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i<arr.length;i++){
//            if(map.containsKey(arr[i])){
//                if((i * map.get(arr[i]))%k == 0){
//                    c++;
//                    map.put(arr[i],i);
//
//                }
//            }
//            else {
//                map.put(arr[i],i);
//            }
//
//        }
//        return c;
//    }



//    public static int gloves(int[] arr){
//        Map<Integer,Integer> map = new HashMap<>();
//        int c = 0;
//        for(int i = 0; i<arr.length; i++){
//            if(map.containsKey(arr[i])){
//                map.remove(arr[i]);
//                c++;
//            }
//            else{
//                map.put(arr[i],1);
//            }
//        }
//        return c;
//    }
}
