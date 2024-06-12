package com.learn.algorithms.strings;

import java.util.*;

public class CommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        String[] words1 = {"cool","lock","cook"};

        System.out.println(commonChars(words));
        System.out.println(commonChars(words1));

    }

    public static List<String> commonChars(String[] words) {

        Map<Character, Integer> map = new HashMap<>();
        char[] char1 = words[0].toCharArray();
        for(char c1:char1) {
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }

        for(int i = 1; i < words.length; i++) {
            char[] char2 = words[i].toCharArray();
            Map<Character, Integer> map1 = new HashMap<>();
            for(char c2:char2) {
                map1.put(c2, map1.getOrDefault(c2, 0) + 1);
            }

            Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Character, Integer> current = it.next();
                char mapKey = current.getKey();
                if(map1.containsKey(mapKey)) {
                    map.put(mapKey, Math.min(map.get(mapKey), map1.get(mapKey)));
                }
                else {
                    it.remove();
                }
            }
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> en: map.entrySet()) {
            for(int k = 0; k < en.getValue(); k++) {
                list.add(String.valueOf(en.getKey()));
            }
        }
        return  list;
    }
}
