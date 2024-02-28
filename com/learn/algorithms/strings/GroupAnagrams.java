package com.learn.algorithms.strings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(doGroupAnagram(strs));
    }

    public static List<List<String>> doGroupAnagram(String[] strs){
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(mySort(strs[i]))) {
                map.put(mySort(strs[i]), new ArrayList<>());
            }
            map.get(mySort(strs[i])).add(strs[i]);
        }
        List<List<String>> resultList = new ArrayList<>();
        for (List<String> list : map.values()) {
            resultList.add(list);
        }
        return resultList;
    }

    public static String mySort(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
