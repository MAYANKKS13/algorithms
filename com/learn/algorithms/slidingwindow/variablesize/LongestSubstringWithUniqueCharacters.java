package com.learn.algorithms.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestSubstringWithUniqueCharacters {
    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(longestSubstringWithUniqueCharacters(s));

    }

    public static int longestSubstringWithUniqueCharacters(String s){

        int n= s.length();
        int i = 0, j = 0;
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(j < n){
            if(map.containsKey(s.charAt(j))){
                int count = map.get(s.charAt(j));
                map.put(s.charAt(j), count + 1);
            }
            else {
                map.put(s.charAt(j), 1);
            }

            if(map.size() == (j-i+1)){
                length = Math.max(length, j-i+1);
                j++;
            }
            else if(map.size()< (j-i+1)){
                while(map.size()< (j-i+1)){
                    if(map.containsKey(s.charAt(i))){
                        if(map.get(s.charAt(i)) == 1){
                            map.remove(s.charAt(i));
                        }
                        else{
                            map.put(s.charAt(i), map.get(s.charAt(i))-1);
                        }
                    }
                    i++;
                }
                j++;

            }

        }

        return length;

        


        // Set<Character> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     if(!set.contains(s.charAt(i))){
        //         set.add(s.charAt(i));
        //         length = Math.max(length,i-j+1);

        //     }
        //     else if(set.contains(s.charAt(i))){
        //         // set.remove(s.charAt(j));
        //         j++;
        //         if(j < n &&  s.charAt(j)==s.charAt(i)){
        //             j++;
        //         }
        //         // set.add(s.charAt(i));
        //     }
        // }

    }
}
